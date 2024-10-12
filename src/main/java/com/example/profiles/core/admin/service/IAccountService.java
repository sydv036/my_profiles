package com.example.profiles.core.admin.service;

import com.example.profiles.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getAccounts() throws Exception;

    Boolean saveOrUpdate(Account account) throws Exception;
}
