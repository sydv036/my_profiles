package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.entity.Account;

import java.util.List;

public interface IAccountAdminService {
    List<Account> getAccounts() throws Exception;

    Boolean saveOrUpdateAccount(DataRequest dataRequest) throws Exception;

    Account getAccountById(String id);
}
