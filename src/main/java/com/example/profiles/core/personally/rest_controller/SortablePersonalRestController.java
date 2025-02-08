package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.common.LogCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.CertificateResponse;
import com.example.profiles.core.personally.service.ISortableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class SortablePersonalRestController {

    @Autowired
    private ISortableService sortableService;

    @GetMapping("/sortable")
    public ResponseEntity<?> getSortable() {
        try {
            String[] sortableList = sortableService.getListValues(ValueConstant.CITIZENCARD_CONST);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", sortableList));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }
    }
}
