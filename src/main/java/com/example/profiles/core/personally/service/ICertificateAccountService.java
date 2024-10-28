package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.CertificateResponse;

import java.util.List;

public interface ICertificateAccountService {

    List<CertificateResponse> getCertificateByCitizenCard(String citizenCard) throws Exception;
}
