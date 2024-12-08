package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.ProjectAdminRequest;
import com.example.profiles.core.admin.service.IProjectAdminService;
import com.example.profiles.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
@CrossOrigin("*")
public class ProjectAdminRestController {
    @Autowired
    private IProjectAdminService projectAdminService;

    @PostMapping("/updateProject")
    public ResponseEntity<?> updateProject(@RequestBody DataRequest dataRequest) {
        try {
            boolean isCheck = projectAdminService.updateProject(dataRequest);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (CustomException e) {
            throw e;
        }
    }

    @PostMapping("/saveProject")
    public ResponseEntity<?> saveProject(@RequestBody ProjectAdminRequest projectAdminRequest) {
        try {
            boolean isCheck = projectAdminService.saveProject(projectAdminRequest);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (CustomException e) {
            throw e;
        }
    }
}
