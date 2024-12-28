package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.common.LogCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.EducationAdminRequest;
import com.example.profiles.core.admin.service.IEducationAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
@CrossOrigin("*")
public class EducationAdminRestController {

    @Autowired
    private IEducationAdminService educationAdminService;

    @PostMapping("/updateEducation")
    public ResponseEntity<?> updateEducation(@RequestBody DataRequest dataRequest) {
        try {
            boolean isCheck = educationAdminService.updateEducationAdmin(dataRequest);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (Exception e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }

    @PostMapping("/createEducation")
    public ResponseEntity<?> createEducation(@RequestBody EducationAdminRequest educationAdminRequest) {
        try {
            boolean isCheck = educationAdminService.saveEducationAdmin(educationAdminRequest);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (Exception e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/deleteEducation/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") String id) {
        try {
            boolean isCheck = educationAdminService.deleteEducationAdmin(id);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (Exception e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }
}
