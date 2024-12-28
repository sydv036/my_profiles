package com.example.profiles.core.personally.service;

import org.springframework.data.repository.query.Param;

public interface ISysParamService {

    String getValueByCitizenCardAAndFunctionName(String citizenCard, String functionName);

}
