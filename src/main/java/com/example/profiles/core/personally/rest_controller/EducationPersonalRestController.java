package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.CertificateResponse;
import com.example.profiles.core.personally.dtos.response.EducationResponse;
import com.example.profiles.core.personally.dtos.response.TargetResponse;
import com.example.profiles.core.personally.service.IEducationAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class EducationPersonalRestController {


    @Autowired
    private IEducationAccountService educationAccountService;

    @GetMapping("/education")
    public ResponseEntity<?> getEducation() throws Exception {
        try {
            List<EducationResponse> educationResponses = educationAccountService.getEducationByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", educationResponses));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }
    }
}
