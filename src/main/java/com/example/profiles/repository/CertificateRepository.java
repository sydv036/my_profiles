package com.example.profiles.repository;

import com.example.profiles.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, String> {
}
