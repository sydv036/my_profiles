package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import com.example.profiles.core.personally.service.IAccountSerice;
import com.example.profiles.core.personally.service.ISkillAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfileRestController {

    @Autowired
    private IAccountSerice accountSerice;

    @Autowired
    private ISkillAccountService skillAccountService;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        ProfileResponse profileResponse = accountSerice.getProfileByCitizenCard("040203027904");
        List<SkillsResponse> skillsResponseList = skillAccountService.getSkillsOfProfileByCitizenCard(profileResponse.getCitizenCard());


        profileResponse.setSkillsResponses(skillsResponseList);
        return ResponseEntity.status(200).body(profileResponse);
    }
}
