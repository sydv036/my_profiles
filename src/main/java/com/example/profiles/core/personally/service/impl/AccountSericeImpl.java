package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.core.personally.reponsitory.IAccountRepository;
import com.example.profiles.core.personally.service.IAccountSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSericeImpl implements IAccountSerice {

    @Autowired
    private IAccountRepository accountReponsitory;

    @Override
    public ProfileResponse getProfileByCitizenCard(String citizenCard) throws Exception {
        try {
            ProfileResponse profileResponse = accountReponsitory.getProfileByCitizenCard(citizenCard);
            return profileResponse;
        } catch (Exception e) {
            throw new Exception("Could not get profile by citizenCard: " + e.getMessage());
        }

    }
}
