package com.example.profiles.repository;

import com.example.profiles.entity.SkillAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillTypeRepository extends JpaRepository<SkillAccount, String> {
}
