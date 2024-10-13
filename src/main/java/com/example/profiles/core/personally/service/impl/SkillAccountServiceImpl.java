package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import com.example.profiles.core.personally.reponsitory.ISkillsAccountRespository;
import com.example.profiles.core.personally.service.ISkillAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillAccountServiceImpl implements ISkillAccountService {

    @Autowired
    private ISkillsAccountRespository skillsAccountResponsitory;

    @Override
    public List<SkillsResponse> getSkillsOfProfileByCitizenCard(String citizenCard) throws Exception {
        try {
            List<SkillsResponse> skillsResponseList = skillsAccountResponsitory.getSkillsOfProfileByCitizenCard(citizenCard);
            return skillsResponseList;
        } catch (Exception e) {
            throw new Exception("Could not get skills by citizenCard: " + e.getMessage());
        }

    }
}
