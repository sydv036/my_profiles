package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.IExperienceAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.IExperienceAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Experience;
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
            if (Optional.ofNullable(dataRequest.getId()).isEmpty()) {
                throw new CustomException(HttpStatus.NOT_FOUND, MessageCommon.getMessageByKey("MES001T"));
            }
            Experience exception = getExperienceByID(dataRequest.getId());
            Experience experienceUpdate = new GenObjectCommon<>(Experience.class).genObject(exception, dataRequest);
            experienceProcess = experienceAdminRepository.saveAndFlush(experienceUpdate);
            if (experienceUpdate == null) {
                throw new CustomException(HttpStatus.UNPROCESSABLE_ENTITY, MessageCommon.getMessageByKey("MES001T"));
            }
            LogCommon.logInfo("Data update: " + experienceProcess.toString());
            return true;
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
            if (Optional.ofNullable(id).isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES009T"));
            }
            Optional<Experience> experience = experienceAdminRepository.findById(id);
            if (experience.isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES010T"));
            }
            return experience.get();
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

}
