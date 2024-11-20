package com.example.profiles.repository;

import com.example.profiles.entity.SkillAccount;
import com.example.profiles.entity.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillTypeRepository extends JpaRepository<SkillType, String> {
}
