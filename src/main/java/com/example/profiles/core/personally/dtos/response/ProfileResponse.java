package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.*;
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
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String adress;
    private String image;
    private String link;
    private Integer flag;
    private List<SkillsResponse> skills;
    private List<EducationResponse> education;
    private List<ProjectResponse> project;
    private List<ExperienceResponse> experience;
    private List<TargetResponse> target;

//    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<CertificateAccount> certificateAccounts;
//
//    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<EducationAccount> educationAccounts;
//
//    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<Experience> experiences;
//
//    @OneToOne
//    @JoinColumn(name = "JobTitleApplyID")
//    private com.example.profiles.entity.JobTitleApply JobTitleApply;
//
//    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
//    private Set<Project> projects;


    public ProfileResponse(String citizenCard, String fullName, LocalDate birthDate, String email, String phoneNumber, String adress, String image, String link, Integer flag) {
        this.citizenCard = citizenCard;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.image = image;
        this.link = link;
        this.flag = flag;
    }


}
