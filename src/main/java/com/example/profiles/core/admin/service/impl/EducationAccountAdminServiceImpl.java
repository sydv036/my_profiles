package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.core.admin.repository.IEducationAccountAdminRepository;
import com.example.profiles.core.admin.service.IEducationAccountAdminService;
import com.example.profiles.entity.EducationAccount;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationAccountAdminServiceImpl implements IEducationAccountAdminService {

    @Autowired
    private IEducationAccountAdminRepository educationAccountAdminRepository;

    @Override
    @Transactional
    public boolean saveEducationAccount(EducationAccount educationAccount) {
        LogCommon.startLog();
        try {
            CheckIsNullCommon.isIdCheck(educationAccount);
            Object obj = educationAccountAdminRepository.saveAndFlush(educationAccount);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, obj);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }
}
