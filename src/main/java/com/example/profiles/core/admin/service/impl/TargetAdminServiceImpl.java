package com.example.profiles.core.admin.service.impl;

import com.example.profiles.base.BaseReponse;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        try {
            Target targetSave = null;
            TargetAccount targetAccountSave = null;
            TargetType targetType = getTargetTypeByEnum(typeTarget);
            if (targetType == null) {
                return false;
            }
            Account account = accountAdminRepository.findAccountByCitizenCard("040203027904q");
            if (account == null) {
                throw new CustomException(HttpStatus.NOT_FOUND, "Do not get data for information");
            }
            if (dataRequest.getId() == null || dataRequest.getId().isEmpty()) {

                Target target = new Target(dataRequest.getValueNew(), targetType);
                targetSave = targetAdminRepository.save(target);
                TargetAccount targetAccount = new TargetAccount(target, account);
                targetAccountSave = targetAccountAdminRepository.save(targetAccount);
                if (targetSave == null || targetAccountSave == null) {
//                    Rollback data
                    throw new CustomException(HttpStatus.BAD_REQUEST, "Do not save data for information");
                }
                return true;
            }

            Optional<Target> targetSearchById = targetAdminRepository.findById(dataRequest.getId());
            if (!targetSearchById.isEmpty()) {
                targetSearchById.get().setTargetType(targetType);
                targetSearchById.get().setTargetName(dataRequest.getValueNew());
                targetSave = targetAdminRepository.saveAndFlush(targetSearchById.get());
                return targetSave != null;
            }
            throw new CustomException(HttpStatus.BAD_REQUEST, "Do not save data for information");
        } catch (Exception e) {
            throw new CustomException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage().toString());
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


