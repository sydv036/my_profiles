package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.CertificateResponse;
import com.example.profiles.core.personally.reponsitory.ICertificateAccountRepository;
import com.example.profiles.core.personally.service.ICertificateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateAccountServiceImpl implements ICertificateAccountService {

    @Autowired
    private ICertificateAccountRepository certificateAccountRepository;

    @Override
    public List<CertificateResponse> getCertificateByCitizenCard(String citizenCard) throws Exception {
        try {
            List<CertificateResponse> certificateResponseList = certificateAccountRepository.getCertificateByCitizenCard(citizenCard);
            return certificateResponseList;
        } catch (Exception e) {
            throw new Exception("Could not get certificate: " + e.getMessage());
        }
    }
}
