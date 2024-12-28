package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.entity.Skill;

public interface ISkillAdminService {
    boolean saveOrUpdate(DataRequest dataRequest, int type);

    boolean deleteSkill(String id);

    Skill getSkillById(String id);

}
