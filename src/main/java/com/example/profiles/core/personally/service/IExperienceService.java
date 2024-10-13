package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.ExperienceResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExperienceService {
    List<ExperienceResponse> getExperienceByCitizenCard(String citizenCard) throws Exception;
}
