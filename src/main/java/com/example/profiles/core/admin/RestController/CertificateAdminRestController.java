package com.example.profiles.core.admin.RestController;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.common.MessageCommon;
import com.example.profiles.core.admin.dtos.request.CertificateAdminRequest;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.service.ICertificateAdminService;
import com.example.profiles.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
public class CertificateAdminRestController {

    @Autowired
    private ICertificateAdminService certificateAdminService;

    @PostMapping("/updateCert")
    public ResponseEntity<?> updateCertificate(@RequestBody DataRequest dataRequest) throws Exception {
        try {
            boolean isUpdateSuccessfully = certificateAdminService.saveOrUpdateCertificate(dataRequest);
            if (!isUpdateSuccessfully) {
                return ResponseEntity.badRequest().body(new BaseReponse<>(HttpStatus.BAD_REQUEST.value(), MessageCommon.getMessageByKey("MES003T"), null));
            }
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.CREATED.value(), MessageCommon.getMessageByKey("MES002T"), null));

        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseReponse<>(e.getHttpStatus().value(), "Error: " + e.getMessage(), null));
        }
    }

    @PostMapping("/createCert")
    public ResponseEntity<?> createCert(@RequestBody CertificateAdminRequest certificateAdminRequest) {
        try {
            boolean isUpdateSuccessfully = certificateAdminService.createCertificate(certificateAdminRequest);
            if (!isUpdateSuccessfully) {
                return ResponseEntity.badRequest().body(new BaseReponse<>(HttpStatus.BAD_REQUEST.value(), MessageCommon.getMessageByKey("MES003T"), null));
            }
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.CREATED.value(), MessageCommon.getMessageByKey("MES002T"), null));

        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseReponse<>(e.getHttpStatus().value(), "Error: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/deleteCertificate/{id}")
    public ResponseEntity<?> deleteCertificate(@PathVariable("id") String id) {
        boolean isCheck = certificateAdminService.deleteCertificate(id);
        return CheckProcessCommon.isProcess(isCheck);
    }

}
