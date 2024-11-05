package com.example.profiles.core.admin.RestController;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ITargetAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
@CrossOrigin("*")
public class ProfileAdminRestController {

    @Autowired
    private IAccountAdminService accountAdminService;

    @Autowired
    private ITargetAdminService targetAdminService;

    @PostMapping("/information")
    public ResponseEntity<?> saveProfile(@RequestBody DataRequest dataRequest) throws Exception {
        try {
            boolean isUpdateSuccessfully = accountAdminService.saveOrUpdate(dataRequest);
            if (!isUpdateSuccessfully) {
                return ResponseEntity.badRequest().body(new BaseReponse<>(HttpStatus.BAD_REQUEST.value(), "Bad request", null));
            }
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.CREATED.value(), "Successfully saved profile", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseReponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + e.getMessage(), null));
        }
    }

    @PostMapping("/updateTarge/{type}")
    public ResponseEntity<?> updateTarge(@RequestBody DataRequest dataRequest, @PathVariable("type") String type) {
        try {
            boolean isUpdateSuccessfully = targetAdminService.saveOrUpdate(dataRequest, Integer.parseInt(type));
            if (!isUpdateSuccessfully) {
                return ResponseEntity.badRequest().body(new BaseReponse<>(HttpStatus.BAD_REQUEST.value(), "Bad request", null));
            }
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.CREATED.value(), "Successfully saved profile", null));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseReponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + e.getMessage(), null));
        }
    }
}
