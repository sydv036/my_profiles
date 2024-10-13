package com.example.profiles.core.personally.rest_controller;

import com.example.profiles.base.BaseReponse;
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
@RequestMapping("/api/v1")
public class ProfileRestController {

    @Autowired
    private IAccountSerice accountSerice;

    @Autowired
    private ISkillAccountService skillAccountService;

    @Autowired
    private IEducationAccountService educationAccountService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IExperienceService experienceService;

    @Autowired
    private ITargetAccountService targetAccountService;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() throws Exception {
        try {
            ProfileResponse profileResponse = accountSerice.getProfileByCitizenCard("040203027904");
            String citizenCard = profileResponse.getCitizenCard();
            List<SkillsResponse> skillsResponseList = skillAccountService.getSkillsOfProfileByCitizenCard(citizenCard);
            List<EducationResponse> educationResponseList = educationAccountService.getEducationByCitizenCard(citizenCard);
            List<ProjectResponse> projectResponseList = projectService.getProjectByCitizenCard(citizenCard);
            List<ExperienceResponse> experienceResponseList = experienceService.getExperienceByCitizenCard(citizenCard);
            List<TargetResponse> targetResponseList = targetAccountService.getTargetByCitizenCard(citizenCard);

            profileResponse.setSkills(skillsResponseList);
            profileResponse.setEducation(educationResponseList);
            profileResponse.setProject(projectResponseList);
            profileResponse.setExperience(experienceResponseList);
            profileResponse.setTarget(targetResponseList);
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.OK.value(), "Successfully", profileResponse));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseReponse<>(HttpStatus.NOT_FOUND.value(), "Profile NotFound", null));
        }

    }
}
