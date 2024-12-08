package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.EducationAdminRequest;
import com.example.profiles.core.admin.repository.IEducationAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.IEducationAccountAdminService;
import com.example.profiles.core.admin.service.IEducationAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Education;
import com.example.profiles.entity.EducationAccount;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationAdminServiceImpl implements IEducationAdminService {

    @Autowired
    private IEducationAdminRepository educationAdminRepository;

    @Autowired
    private IEducationAccountAdminService educationAccountAdminService;

    @Autowired
    private IAccountAdminService accountAdminService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public boolean saveEducationAdmin(EducationAdminRequest educationAdminRequest) {
        LogCommon.startLog();
        try {
            CheckIsNullCommon.isIdCheck(educationAdminRequest);
            Education education = modelMapper.map(educationAdminRequest, Education.class);
            Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
            EducationAccount educationAccount = new EducationAccount(education, account);
            Object objEduSave = educationAdminRepository.saveAndFlush(education);
            Object objEduAccSave = educationAccountAdminService.saveEducationAccount(educationAccount);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, objEduSave) && CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, objEduAccSave);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public boolean updateEducationAdmin(DataRequest dataRequest) {
        LogCommon.startLog();
        try {
            CheckIsNullCommon.isIdCheck(dataRequest);
            Education education = getEducationById(dataRequest.getId());
            education = new GenObjectCommon<>(Education.class).genObject(education, dataRequest);
            Object obj = educationAdminRepository.saveAndFlush(education);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, obj);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Education getEducationById(String id) {
        try {
            CheckIsNullCommon.isIdCheck(id);
            Education education = educationAdminRepository.findById(id).get();
            CheckIsNullCommon.isIdCheck(education);
            return education;
        } catch (Exception e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }
}
