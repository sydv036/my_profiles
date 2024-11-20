package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAdminServiceImpl implements IAccountAdminService {

    @Autowired
    private IAccountAdminRepository accountRepository;

    @Override
    public List<Account> getAccounts() throws Exception {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean saveOrUpdate(DataRequest dataRequest) throws Exception {
        try {
            Account account = accountRepository.findAccountByCitizenCard(dataRequest.getId());
            if (account == null) {
                return false;
            }
            account = new GenObjectCommon<>(Account.class).genObject(account, dataRequest);
            Account accountSave = accountRepository.save(account);
            return accountSave != null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
