package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ICertificateAccountAdminRepository;
import com.example.profiles.core.admin.repository.ICertificateAdminRepository;
import com.example.profiles.core.admin.service.ICertificateAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Certificate;
import com.example.profiles.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateAdminServiceImpl implements ICertificateAdminService {
    @Autowired
    private ICertificateAdminRepository certificateAdminRepository;

    @Autowired
    private ICertificateAccountAdminRepository certificateAccountAdminRepository;

    @Autowired
    private IAccountAdminRepository accountAdminRepository;

    @Override
    public boolean saveOrUpdateCertificate(DataRequest dataRequest) {
        LogCommon.startLog();
        Certificate certificateSave = null;
        try {
            Account account = accountAdminRepository.findAccountByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            if (Optional.ofNullable(account).isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES001T"));
            }
            if (Optional.ofNullable(dataRequest.getId()).isPresent()) {
                Certificate certificate = certificateAdminRepository.findById(dataRequest.getId()).get();
                try {
                    certificate = new GenObjectCommon<>(Certificate.class).genObject(certificate, dataRequest);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    throw new CustomException(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE, e.getMessage());

                }
                certificateSave = certificateAdminRepository.saveAndFlush(certificate);
                return Optional.ofNullable(certificateSave).isPresent();
            }
            throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES003T"));
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }
}
