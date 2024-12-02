package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountAdminServiceImpl implements IAccountAdminService {

    @Autowired
    private IAccountAdminRepository accountRepository;

    @Override
    public List<Account> getAccounts() throws Exception {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Boolean saveOrUpdateAccount(DataRequest dataRequest) throws Exception {
        try {
            Account account = accountRepository.findAccountByCitizenCard(dataRequest.getId());
            if (account == null) {
                return false;
            }
            account = new GenObjectCommon<>(Account.class).genObject(account, dataRequest);
            Account accountSave = accountRepository.save(account);
            return accountSave != null;
        } catch (CustomException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Account getAccountById(String id) {
        LogCommon.startLog();
        try {
            Account account = accountRepository.findAccountByCitizenCard(id);
            if (Optional.ofNullable(account).isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES001T"));
            }
            return account;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        } finally {
            LogCommon.endLog();
        }
    }
}
