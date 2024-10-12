package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISkillAccountService {
    List<SkillsResponse> getSkillsOfProfileByCitizenCard(String citizenCard);
}
