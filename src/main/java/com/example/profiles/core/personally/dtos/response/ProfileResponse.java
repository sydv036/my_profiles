package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProfileResponse {
    private String citizenCard;
    private String fullName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String adress;
    private String image;
    private String link;
    private Integer flag;
    private String jobTitleApply;
    private List<SkillsResponse> skills;
    private List<EducationResponse> education;
    private List<ProjectResponse> project;
    private List<ExperienceResponse> experience;
    private List<TargetResponse> target;
    private List<CertificateResponse> certificate;

    public ProfileResponse(String citizenCard, String fullName, LocalDate birthDate, String email, String phoneNumber, String adress, String image, String link, Integer flag, String jobTitleApply) {
        this.citizenCard = citizenCard;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.image = image;
        this.link = link;
        this.flag = flag;
        this.jobTitleApply = jobTitleApply;
    }
}
