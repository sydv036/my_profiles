package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.core.admin.service.ISkillAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class SkillAdminRestController {

    @Autowired
    private ISkillAdminService skillAdminService;

    @DeleteMapping("/deleteSkill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") String id) {
        boolean isCheck = skillAdminService.deleteSkill(id);
        return CheckProcessCommon.isProcess(isCheck);
    }
}
