package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.Experience;
import com.example.profiles.repository.ExperienceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceAdminRepository extends JpaRepository<Experience,String> {
}
