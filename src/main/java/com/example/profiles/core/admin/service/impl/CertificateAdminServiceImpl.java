package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.*;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.CertificateAdminRequest;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.IAccountAdminRepository;
import com.example.profiles.core.admin.repository.ICertificateAccountAdminRepository;
import com.example.profiles.core.admin.repository.ICertificateAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ICertificateAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.Certificate;
import com.example.profiles.entity.CertificateAccount;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
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
    private IAccountAdminService accountAdminService;

    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public boolean saveOrUpdateCertificate(DataRequest dataRequest) {
        LogCommon.startLog();
        Certificate certificateSave = null;
        try {
            dataRequest = (DataRequest) CheckIsNullCommon.isIdCheck(dataRequest);
            Certificate certificate = getCertificateById(dataRequest.getId());
            certificate = new GenObjectCommon<>(Certificate.class).genObject(certificate, dataRequest);
            certificateSave = certificateAdminRepository.saveAndFlush(certificate);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, certificateSave);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    @Override
    @Transactional
    public boolean createCertificate(CertificateAdminRequest certificateAdminRequest) {
        LogCommon.startLog();
        try {
            Certificate certificateSave = null;
            CertificateAccount certificateAccountSave = null;
            Account account = accountAdminService.getAccountById(ValueConstant.CITIZENCARD_CONST);
            Certificate certificate = mapper.map(certificateAdminRequest, Certificate.class);
            certificateSave = certificateAdminRepository.saveAndFlush(certificate);
            CertificateAccount certificateAccount = new CertificateAccount(certificate, account);
            certificateAccountSave = certificateAccountAdminRepository.saveAndFlush(certificateAccount);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, certificateSave) && CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_CREATE, certificateAccountSave);
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteCertificate(String id) {
        try {
            getCertificateById(id);
            certificateAdminRepository.deleteById(id);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_DELETE, true);
        } catch (CustomException e) {
            throw e;
        }
    }

    @Override
    public Certificate getCertificateById(String id) {
        LogCommon.startLog();
        try {
            CheckIsNullCommon.isIdCheck(id);
            Certificate certificate = certificateAdminRepository.findById(id).get();
            CheckIsNullCommon.isIdCheck(certificate);
            return certificate;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } finally {
            LogCommon.endLog();
        }
    }
}
