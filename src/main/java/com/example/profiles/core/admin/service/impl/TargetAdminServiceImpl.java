package com.example.profiles.core.admin.service.impl;

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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TargetAdminServiceImpl implements ITargetAdminService {

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
    public boolean saveOrUpdate(DataRequest dataRequest, int typeTarget) {
        Target targetSave = null;
        TargetAccount targetAccountSave = null;
        TargetType targetType = getTargetTypeByEnum(typeTarget);
        if (targetType == null) {
            return false;
        }
        if (dataRequest.getId().isEmpty()) {
            Account account = accountAdminRepository.findAccountByCitizenCard("040203027904");
            Target target = Target.builder()
                    .targetName(dataRequest.getValueNew())
                    .targetType(targetType)
                    .build();
            targetSave = targetAdminRepository.save(target);
            TargetAccount targetAccount = TargetAccount.builder()
                    .target(target)
                    .account(account)
                    .build();
            targetAccountSave = targetAccountAdminRepository.save(targetAccount);
            if (targetSave == null || targetAccountSave == null) {
                throw new RuntimeException("Could not update data");
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
        throw new RuntimeException("Could not update data");


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


