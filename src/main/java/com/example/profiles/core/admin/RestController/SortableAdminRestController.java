package com.example.profiles.core.admin.RestController;

import com.example.profiles.common.CheckProcessCommon;
import com.example.profiles.core.admin.service.ISortableAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/")
public class SortableAdminRestController {

    @Autowired
    private ISortableAdminService sortableAdminService;

    @PostMapping("/save-sortable")
    public ResponseEntity<?> saveSortable(@RequestBody String sortable) {
        boolean isCheck = sortableAdminService.saveSortable(sortable);
        return CheckProcessCommon.isProcess(isCheck);
    }
}
