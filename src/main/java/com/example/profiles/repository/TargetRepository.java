package com.example.profiles.repository;

import com.example.profiles.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<Target, String> {
}
