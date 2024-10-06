package com.example.profiles.repository;

import com.example.profiles.entity.CertificateAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateAccountRepository extends JpaRepository<CertificateAccount, String> {
}
