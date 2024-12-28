package com.example.profiles.core.personally.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.core.personally.reponsitory.ISysParamRepository;
import com.example.profiles.core.personally.service.ISysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysParamServiceImpl implements ISysParamService {

    @Autowired
    private ISysParamRepository sysParamRepository;

    /**
     * @param citizenCard
     * @param functionName
     * @return
     */
    @Override
    public String getValueByCitizenCardAAndFunctionName(String citizenCard, String functionName) {
        try {
            CheckIsNullCommon.isIdCheck(citizenCard);
            CheckIsNullCommon.isIdCheck(functionName);
            String value = sysParamRepository.getValueByCitizenCardAAndFunctionName(citizenCard, functionName);
            CheckIsNullCommon.isIdCheck(value);
            return value;
        } catch (Exception e) {
            throw e;
        }
    }
}
