package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.EducationResponse;
import com.example.profiles.core.personally.reponsitory.IEducationAccountRepository;
import com.example.profiles.core.personally.service.IEducationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationAccountServiceImpl implements IEducationAccountService {

    @Autowired
    private IEducationAccountRepository educationAccountReponsitory;

    @Override
    public List<EducationResponse> getEducationByCitizenCard(String citizenCard) throws Exception {
        try {
            List<EducationResponse> educationResponseList = educationAccountReponsitory.getEducationByCitizenCard(citizenCard);
            return educationResponseList;
        } catch (Exception e) {
            throw new Exception("Couldn't get Education: " + e.getMessage());
        }
    }
}
