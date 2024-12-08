package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ISkillAdminRepository;
import com.example.profiles.core.admin.repository.ISkillTypeAdminRepository;
import com.example.profiles.core.admin.repository.ISkillsAccountAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ISkillAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Skill;
import com.example.profiles.entity.SkillAccount;
import com.example.profiles.entity.SkillType;
import com.example.profiles.enums.FlagCurdEnum;
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
    private IAccountAdminService accountAdminService;


    @Override
    @Transactional
    public boolean saveOrUpdate(DataRequest dataRequest, int type) {
        LogCommon.startLog();
        try {
            Skill skillSave = null;
            SkillAccount skillAccountSave = null;
            if (Optional.ofNullable(dataRequest.getId()).isEmpty()) {
                SkillType skillType = getSkillType(type);
                CheckIsNullCommon.isIdCheck(skillType);
                Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
                Skill skill = new Skill(dataRequest.getValueNew(), skillType);
                SkillAccount skillAccount = new SkillAccount(skill, account);
                skillSave = skillAdminRepository.save(skill);
                skillAccountSave = skillsAccountAdminRepository.save(skillAccount);
                return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, skillSave) && CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, skillAccountSave);
            }
            Skill skillGetByID = getSkillById(dataRequest.getId());
            skillGetByID.setSkillName(dataRequest.getValueNew());
            skillSave = skillAdminRepository.saveAndFlush(skillGetByID);
            LogCommon.logInfo(MessageCommon.getMessageByKey("MES002T"));
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, skillSave);
        } catch (CustomException e) {
            LogCommon.logError("Error: " + e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    public Skill getSkillById(String id) {
        try {
            CheckIsNullCommon.isIdCheck(id);
            Skill skill = skillAdminRepository.findById(id).get();
            CheckIsNullCommon.isIdCheck(skill);
            return skill;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
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
