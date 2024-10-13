package com.example.profiles.repository;

import com.example.profiles.entity.TargetAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetAccountRepository extends JpaRepository<TargetAccount, String> {
}
