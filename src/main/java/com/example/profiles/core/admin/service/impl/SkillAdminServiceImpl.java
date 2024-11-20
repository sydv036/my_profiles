package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ISkillAdminRepository;
import com.example.profiles.core.admin.repository.ISkillTypeAdminRepository;
import com.example.profiles.core.admin.repository.ISkillsAccountAdminRepository;
import com.example.profiles.core.admin.service.ISkillAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Skill;
import com.example.profiles.entity.SkillAccount;
import com.example.profiles.entity.SkillType;
import com.example.profiles.enums.SkillTypeEnum;
import com.example.profiles.exception.CustomException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillAdminServiceImpl implements ISkillAdminService {

    @Autowired
    private ISkillTypeAdminRepository skillTypeAdminRepository;

    @Autowired
    private ISkillsAccountAdminRepository skillsAccountAdminRepository;

    @Autowired
    private ISkillAdminRepository skillAdminRepository;

    @Autowired
    private IAccountAdminRepository accountAdminRepository;


    @Override
    @Transactional
    public boolean saveOrUpdate(DataRequest dataRequest, int type) {
        LogCommon.startLog();
        try {
            Skill skillSave = null;
            SkillAccount skillAccountSave = null;
            SkillType skillType = getSkillType(type);
            if (Optional.ofNullable(skillType).isEmpty()) {
                throw new CustomException(HttpStatus.NOT_FOUND, MessageCommon.getMessageByKey("MES001T"));
            }
            Account account = accountAdminRepository.findAccountByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            if (Optional.ofNullable(account).isEmpty()) {
                throw new CustomException(HttpStatus.NOT_FOUND, MessageCommon.getMessageByKey("MES001T"));
            }

            if (Optional.ofNullable(dataRequest.getId()).isEmpty()) {
                Skill skill = new Skill(dataRequest.getValueNew(), skillType);
                SkillAccount skillAccount = new SkillAccount(skill, account);
                skillSave = skillAdminRepository.save(skill);
                skillAccountSave = skillsAccountAdminRepository.save(skillAccount);
                if (Optional.ofNullable(skillSave).isPresent() && Optional.ofNullable(skillAccountSave).isPresent()) {
                    LogCommon.logInfo(MessageCommon.getMessageByKey("MES002T"));
                    return true;
                }
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES003T"));
            }

            Optional<Skill> skillGetByID = skillAdminRepository.findById(dataRequest.getId());
            if (skillGetByID.isPresent()) {
                skillGetByID.get().setSkillName(dataRequest.getValueNew());
                skillSave = skillAdminRepository.saveAndFlush(skillGetByID.get());
                LogCommon.logInfo(MessageCommon.getMessageByKey("MES002T"));
                return Optional.ofNullable(skillSave).isPresent();
            }
            throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES001T"));

        } catch (CustomException e) {
            LogCommon.logError("Error: " + e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    private SkillType getSkillType(int type) {
        switch (type) {
            case 0:
                return skillTypeAdminRepository.findFirstBySkillTypeName(SkillTypeEnum.PROFESSIONAL_SKILLS.ordinal());
            case 1:
                return skillTypeAdminRepository.findFirstBySkillTypeName(SkillTypeEnum.SOFT_SKILLS.ordinal());
            default:
                return null;
        }

    }
}
