package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.*;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.IExperienceAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.IExperienceAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Experience;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceAdminServiceImpl implements IExperienceAdminService {

    @Autowired
    private IExperienceAdminRepository experienceAdminRepository;

    @Autowired
    private IAccountAdminService accountAdminService;

    @Override
    @Transactional
    public boolean updateExperience(DataRequest dataRequest) {
        LogCommon.startLog();
        try {
            Experience experienceProcess = null;
            dataRequest = (DataRequest) CheckIsNullCommon.isIdCheck(dataRequest);
            Experience exception = getExperienceByID(dataRequest.getId());
            Experience experienceUpdate = new GenObjectCommon<>(Experience.class).genObject(exception, dataRequest);
            experienceProcess = experienceAdminRepository.saveAndFlush(experienceUpdate);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, experienceProcess);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Experience getExperienceByID(String id) {
        LogCommon.startLog();
        try {
            id = (String) CheckIsNullCommon.isIdCheck(id);
            Optional<Experience> experience = experienceAdminRepository.findById(id);
            experience = (Optional<Experience>) CheckIsNullCommon.isIdCheck(experience);
            return experience.get();
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

}
