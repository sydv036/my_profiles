package com.example.profiles.core.admin.service.impl;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.service.IAccountService;
import com.example.profiles.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

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
            Field[] fields = account.getClass().getDeclaredFields();
            for( Field field : fields ) {
                System.out.println(field.getName());
            }
//            Account accountSave = accountRepository.save(account);
//            return accountSave != null;
            return  true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
