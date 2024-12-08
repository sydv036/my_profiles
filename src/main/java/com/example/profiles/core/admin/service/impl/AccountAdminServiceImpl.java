package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.*;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.enums.FlagCurdEnum;
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
        LogCommon.startLog();
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Boolean saveOrUpdateAccount(DataRequest dataRequest) throws Exception {
        LogCommon.startLog();
        try {
            Account account = getAccountById(dataRequest.getId());
            account = new GenObjectCommon<>(Account.class).genObject(account, dataRequest);
            Account accountSave = accountRepository.saveAndFlush(account);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, accountSave);
        } catch (CustomException e) {
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Account getAccountById(String id) {
        LogCommon.startLog();
        try {
            CheckIsNullCommon.isIdCheck(id);
            Account account = accountRepository.findAccountByCitizenCard(id);
            CheckIsNullCommon.isIdCheck(account);
            return account;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw new CustomException(HttpStatus.BAD_REQUEST, e.getMessage());
        } finally {
            LogCommon.endLog();
        }
    }
}
