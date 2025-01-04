package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.constant.FunctionNameConstant;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.CertificateResponse;
import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.core.personally.service.ICertificateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class CertificatePersonalRestController {

    @Autowired
    private ICertificateAccountService certificateAccountService;

    @GetMapping("/certificate")
    public ResponseEntity<?> getCertificate() throws Exception {
        try {
            List<CertificateResponse> certificateResponseList = certificateAccountService.getCertificateByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", certificateResponseList));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }
    }
}
