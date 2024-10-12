package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.core.personally.responsitory.IAccountReponsitory;
import com.example.profiles.core.personally.service.IAccountSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountSericeImpl implements IAccountSerice {

    @Autowired
    private IAccountReponsitory accountReponsitory;

    @Override
    public ProfileResponse getProfileByCitizenCard(String citizenCard) {
        return accountReponsitory.getProfileByCitizenCard(citizenCard);
    }
}
