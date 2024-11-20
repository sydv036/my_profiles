package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;

public interface ICertificateAdminService {
    boolean saveOrUpdateCertificate(DataRequest dataRequest);
}
