package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.core.admin.service.ITargetAdminService;
import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class TargetAdminRestController {
    private final ITargetAdminService targetAdminService;

    @DeleteMapping("/deleteTarget/{id}")
    public ResponseEntity<?> deleteTargetById(@PathVariable("id") String id) {
        try {
            boolean isCheck = targetAdminService.deleteTarget(id);
            return CheckProcessCommon.isProcess(isCheck);
        } catch (CustomException e) {
            throw e;
        }
    }
}
