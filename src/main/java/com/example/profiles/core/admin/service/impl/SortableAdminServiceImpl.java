package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.repository.ISortableAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ISortableAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Sortable;
import com.example.profiles.enums.FlagCurdEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SortableAdminServiceImpl implements ISortableAdminService {

    @Autowired
    private ISortableAdminRepository sortableAdminRepostory;

    @Autowired
    private IAccountAdminService accountAdminService;

    @Override
    public boolean saveSortable(String sortable) {
        try {
            Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
            Sortable sortableAdd = Sortable.builder()
                    .id(account.getCitizenCard())
                    .flag(0)
                    .value(sortable.replaceAll("\"", ""))
                    .build();
            Object objectSave = sortableAdminRepostory.saveAndFlush(sortableAdd);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, objectSave);
        } catch (Exception e) {
            throw e;
        }
    }
}
