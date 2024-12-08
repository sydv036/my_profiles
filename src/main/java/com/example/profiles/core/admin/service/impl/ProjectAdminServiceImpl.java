package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.*;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.ProjectAdminRequest;
import com.example.profiles.core.admin.repository.IProjectAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.IProjectAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Project;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectAdminServiceImpl implements IProjectAdminService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProjectAdminRepository projectAdminRepository;

    @Autowired
    private IAccountAdminService accountAdminService;

    @Override
    public boolean saveProject(ProjectAdminRequest projectAdminRequest) {
        LogCommon.startLog();
        try {
            Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
            projectAdminRequest = (ProjectAdminRequest) CheckIsNullCommon.isIdCheck(projectAdminRequest);
            Project project = modelMapper.map(projectAdminRequest, Project.class);
            project.setAccount(account);
            Object obj = projectAdminRepository.saveAndFlush(project);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, obj);
        } catch (Exception e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public boolean updateProject(DataRequest dataRequest) {
        LogCommon.startLog();
        try {
            Project project = getProjectById(dataRequest.getId());
            project = new GenObjectCommon<>(Project.class).genObject(project, dataRequest);
            Object obj = projectAdminRepository.saveAndFlush(project);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, obj);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Project getProjectById(String id) {
        LogCommon.startLog();
        try {
            id = (String) CheckIsNullCommon.isIdCheck(id);
            Project project = projectAdminRepository.findById(id).get();
            CheckIsNullCommon.isIdCheck(project);
            LogCommon.logInfo(project.toString());
            return project;
        } catch (CustomException e) {
            e.getMessage();
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

}
