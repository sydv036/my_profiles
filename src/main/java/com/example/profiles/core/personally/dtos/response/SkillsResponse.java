package com.example.profiles.core.personally.dtos.response;


import com.example.profiles.entity.Skill;
import com.example.profiles.entity.SkillType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Skill.class, SkillType.class})
public interface SkillsResponse {
    String getSkillsName();

    String getSkillsIDString();

    String getSkillsTypeID();

    String getSkillsTypeName();
}
