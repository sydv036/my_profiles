package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.CertificateAdminRequest;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.entity.Certificate;

public interface ICertificateAdminService {
    boolean saveOrUpdateCertificate(DataRequest dataRequest);

    boolean createCertificate(CertificateAdminRequest certificateAdminRequest);

    boolean deleteCertificate(String id);

    Certificate getCertificateById(String id);
}
