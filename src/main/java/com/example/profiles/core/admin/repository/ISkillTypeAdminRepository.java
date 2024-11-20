package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.SkillType;
import com.example.profiles.repository.SkillTypeRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillTypeAdminRepository extends SkillTypeRepository {
    SkillType findFirstBySkillTypeName(@Param("skillTypeName") int skillTypeName);

}
