package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.TargetResponse;
import com.example.profiles.core.personally.reponsitory.ITargetAccountRepository;
import com.example.profiles.core.personally.service.ITargetAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetAccountServiceImpl implements ITargetAccountService {

    @Autowired
    private ITargetAccountRepository accountRepository;

    @Override
    public List<TargetResponse> getTargetByCitizenCard(String citizenCard) throws Exception {
        try {
            List<TargetResponse> targetResponseList = accountRepository.getTargetByCitizenCard(citizenCard);
            return targetResponseList;
        } catch (Exception e) {
            throw new Exception("Could not get Target: " + e.getMessage());
        }
    }
}
