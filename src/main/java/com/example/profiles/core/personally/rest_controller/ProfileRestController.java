package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
import com.example.profiles.constant.FunctionNameConstant;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.dtos.response.*;
import com.example.profiles.core.personally.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
public class ProfileRestController {

    @Autowired
    private IAccountSerice accountSerice;

    @Autowired
    private ISysParamService sysParamService;

    @GetMapping("/basic-info")
    public ResponseEntity<?> getProfile() throws Exception {
        try {
            ProfileResponse profileResponse = accountSerice.getProfileByCitizenCard(ValueConstant.CITIZENCARD_CONST);
            String citizenCard = profileResponse.getCitizenCard();
            String color = sysParamService.getValueByCitizenCardAAndFunctionName(citizenCard, FunctionNameConstant.COLOR);
            String fontSize = sysParamService.getValueByCitizenCardAAndFunctionName(citizenCard, FunctionNameConstant.FONT_SIZE);
            String fontFamily= sysParamService.getValueByCitizenCardAAndFunctionName(citizenCard, FunctionNameConstant.FONT_FAMILY);
            profileResponse.setColor(color);
            profileResponse.setFontSize(fontSize);
            profileResponse.setFontFamily(fontFamily);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", profileResponse));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }

    }
}
