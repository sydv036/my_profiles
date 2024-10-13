package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.EducationResponse;
import com.example.profiles.entity.Education;

import java.util.List;

public interface IEducationAccountService {

    List<EducationResponse> getEducationByCitizenCard(String citizenCard) throws Exception;
}
