package com.example.profiles.repository;

import com.example.profiles.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, String> {
}
