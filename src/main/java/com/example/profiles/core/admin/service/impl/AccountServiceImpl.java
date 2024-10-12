package com.example.profiles.core.admin.service.impl;

import com.example.profiles.core.admin.repository.IAccountRepository;
import com.example.profiles.core.admin.service.IAccountService;
import com.example.profiles.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() throws Exception {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean saveOrUpdate(Account account) throws Exception {
        try {
            Account accountSave = accountRepository.save(account);
            return accountSave != null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
