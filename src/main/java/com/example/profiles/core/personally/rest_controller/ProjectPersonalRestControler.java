package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.ExperienceResponse;
import com.example.profiles.core.personally.dtos.response.ProjectResponse;
import com.example.profiles.core.personally.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class ProjectPersonalRestControler {

    @Autowired
    private IProjectService projectService;

    @GetMapping("/project")
    public ResponseEntity<?> getTargetController() throws Exception {
        try {
            List<ProjectResponse> projectResponseList = projectService.getProjectByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", projectResponseList));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }
    }
}
