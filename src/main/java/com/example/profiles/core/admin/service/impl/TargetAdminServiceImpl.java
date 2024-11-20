package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ITargetAccountAdminRepository;
import com.example.profiles.core.admin.repository.ITargetAdminRepository;
import com.example.profiles.core.admin.repository.ITargetTypeAdminRepository;
import com.example.profiles.core.admin.service.ITargetAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Target;
import com.example.profiles.entity.TargetAccount;
import com.example.profiles.entity.TargetType;
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
    private IAccountAdminRepository accountAdminRepository;

    @Override
    @Transactional
    public boolean saveOrUpdate(DataRequest dataRequest, int typeTarget) throws CustomException {
        LogCommon.startLog();
        try {
            Target targetSave = null;
            TargetAccount targetAccountSave = null;
            TargetType targetType = getTargetTypeByEnum(typeTarget);
            if (Optional.ofNullable(targetType).isEmpty()) {
                throw new CustomException(HttpStatus.NOT_FOUND, MessageCommon.getMessageByKey("MES001T"));
            }
            Account account = accountAdminRepository.findAccountByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            if (Optional.ofNullable(account).isEmpty()) {
                throw new CustomException(HttpStatus.NOT_FOUND, MessageCommon.getMessageByKey("MES001T"));
            }
            if (Optional.ofNullable(dataRequest.getId()).isEmpty()) {

                Target target = new Target(dataRequest.getValueNew(), targetType);
                targetSave = targetAdminRepository.save(target);
                TargetAccount targetAccount = new TargetAccount(target, account);
                targetAccountSave = targetAccountAdminRepository.save(targetAccount);
                if (Optional.ofNullable(targetSave).isEmpty() || Optional.ofNullable(targetAccountSave).isEmpty()) {
                    throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES003T"));
                }
                LogCommon.logInfo(MessageCommon.getMessageByKey("MES002T"));
                return true;
            }

            Optional<Target> targetSearchById = targetAdminRepository.findById(dataRequest.getId());
            if (targetSearchById.isPresent()) {
                targetSearchById.get().setTargetName(dataRequest.getValueNew());
                targetSave = targetAdminRepository.saveAndFlush(targetSearchById.get());
                return Optional.ofNullable(targetSave).isPresent();
            }
            throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES003T"));
        } catch (CustomException e) {
            LogCommon.logError("Exception: " + e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
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


