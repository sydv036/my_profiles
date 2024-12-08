package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ITargetAccountAdminRepository;
import com.example.profiles.core.admin.repository.ITargetAdminRepository;
import com.example.profiles.core.admin.repository.ITargetTypeAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ITargetAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Target;
import com.example.profiles.entity.TargetAccount;
import com.example.profiles.entity.TargetType;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.enums.TargetTypeNameEnum;
import com.example.profiles.exception.CustomException;
import com.example.profiles.exception.HandleException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TargetAdminServiceImpl extends HandleException implements ITargetAdminService {

    @Autowired
    private ITargetAdminRepository targetAdminRepository;

    @Autowired
    private ITargetAccountAdminRepository targetAccountAdminRepository;

    @Autowired
    private ITargetTypeAdminRepository targetTypeAdminRepository;

    @Autowired
    private IAccountAdminService accountAdminService;

    @Override
    @Transactional
    public boolean saveOrUpdate(DataRequest dataRequest, int typeTarget) throws CustomException {
        LogCommon.startLog();
        try {
            Target targetSave = null;
            TargetAccount targetAccountSave = null;
            TargetType targetType = getTargetTypeByEnum(typeTarget);
            CheckIsNullCommon.isIdCheck(targetType);
            if (Optional.ofNullable(dataRequest.getId()).isEmpty()) {
                Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
                Target target = new Target(dataRequest.getValueNew(), targetType);
                targetSave = targetAdminRepository.save(target);
                TargetAccount targetAccount = new TargetAccount(target, account);
                targetAccountSave = targetAccountAdminRepository.save(targetAccount);
                return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, targetSave) && CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, targetAccountSave);
            }
            Target targetSearchById = getTargetById(dataRequest.getId());
            targetSearchById.setTargetName(dataRequest.getValueNew());
            targetSave = targetAdminRepository.saveAndFlush(targetSearchById);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, targetSave);

        } catch (CustomException e) {
            LogCommon.logError("Exception: " + e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }


    }

    @Override
    public Target getTargetById(String id) {
        try {
            CheckIsNullCommon.isIdCheck(id);
            Target target = targetAdminRepository.findById(id).get();
            CheckIsNullCommon.isIdCheck(target);
            return target;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }

    private TargetType getTargetTypeByEnum(int targetType) {
        switch (targetType) {
            case 0:
                return targetTypeAdminRepository.getTargetTypeByTargetTypeName(TargetTypeNameEnum.LONG_TARGER.ordinal());
            case 1:
                return targetTypeAdminRepository.getTargetTypeByTargetTypeName(TargetTypeNameEnum.SHOT_TARGET.ordinal());
            default:
                return null;
        }
    }
}


