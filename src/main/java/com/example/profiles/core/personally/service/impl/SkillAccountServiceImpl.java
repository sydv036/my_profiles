package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import com.example.profiles.core.personally.responsitory.ISkillsAccountResponsitory;
import com.example.profiles.core.personally.service.ISkillAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillAccountServiceImpl implements ISkillAccountService {

    @Autowired
    private ISkillsAccountResponsitory skillsAccountResponsitory;

    @Override
    public List<SkillsResponse> getSkillsOfProfileByCitizenCard(String citizenCard) {
        return skillsAccountResponsitory.getSkillsOfProfileByCitizenCard(citizenCard);
    }
}
