package com.example.profiles.core.admin.RestController;


import com.example.profiles.base.BaseReponse;
import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.EducationAdminRequest;
import com.example.profiles.core.admin.dtos.request.ExperienceAdminRequest;
import com.example.profiles.core.admin.service.IExperienceAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
public class ExperienceAdminRestController {

    @Autowired
    private IExperienceAdminService experienceAdminService;

    @PostMapping("/updateExperience")
    public ResponseEntity<?> saveProfile(@RequestBody DataRequest dataRequest) throws Exception {
        return CheckProcessCommon.isProcess(experienceAdminService.updateExperience(dataRequest));
    }

    @PostMapping("/createExperience")
    public ResponseEntity<?> createProfile(@RequestBody ExperienceAdminRequest experienceAdminRequest) throws Exception {
        return CheckProcessCommon.isProcess(experienceAdminService.createExperience(experienceAdminRequest));
    }

    @DeleteMapping("/deleteExperience/{id}")
    public  ResponseEntity<?> deleteExperience(@PathVariable("id") String id){
        boolean result = experienceAdminService.deleteExperience(id);
        return  CheckProcessCommon.isProcess(result);
    }

}
