package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.EducationResponse;
import com.example.profiles.core.personally.dtos.response.ExperienceResponse;
import com.example.profiles.core.personally.service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class ExperiencesPersonalRestController {

    @Autowired
    private IExperienceService experienceService;

    @GetMapping("/experiences")
    public ResponseEntity<?> getTargetController() throws Exception {
        try {
            List<ExperienceResponse> experienceResponseList = experienceService.getExperienceByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", experienceResponseList));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }
    }
}
