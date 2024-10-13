package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.TargetResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITargetAccountService {

    List<TargetResponse> getTargetByCitizenCard(String citizenCard) throws Exception;
}
