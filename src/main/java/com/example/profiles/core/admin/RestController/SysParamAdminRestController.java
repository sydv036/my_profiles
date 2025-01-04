package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.service.ISysParamAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin("*")
public class SysParamAdminRestController {

    @Autowired
    private ISysParamAdminService sysParamAdminService;

    @PostMapping("/updateSysParam")
    public ResponseEntity<?> updateSysParam(@RequestBody DataRequest dataRequest) {
        boolean isCheck = sysParamAdminService.updateSysParam(dataRequest);
        return CheckProcessCommon.isProcess(isCheck);
    }
}
