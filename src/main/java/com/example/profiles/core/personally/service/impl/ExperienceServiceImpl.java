package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.ExperienceResponse;
import com.example.profiles.core.personally.reponsitory.IExperienceReposiroy;
import com.example.profiles.core.personally.service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements IExperienceService {

    @Autowired
    private IExperienceReposiroy experienceReposiroy;

    @Override
    public List<ExperienceResponse> getExperienceByCitizenCard(String citizenCard) throws Exception {
        try {
            List<ExperienceResponse> experienceResponseList = experienceReposiroy.getExperienceByCitizenCard(citizenCard);
            return experienceResponseList;
        } catch (Exception e) {
            throw new Exception("Could not get Experience: " + e.getMessage());
        }
    }
}
