package com.example.profiles.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@SQLDelete(sql = "Update AccountRequest set flag = 1 where citizenCard= ?")
@SQLSelect(sql = "SELECT * FROM AccountRequest ac WHERE ac.flag = 0")
public class Account {
    @Id
    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String citizenCard;
    @Column(columnDefinition = "nvarchar(150)", nullable = false)
    private String fullName;
    private String birthDate;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Column(columnDefinition = "varchar(10)", nullable = false, unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "varchar(5000)")
    private String adress;
    @Column(columnDefinition = "Longtext")
    private String image;
    private String link;
    private String gender;
    private String jobTitleApplly;
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SkillAccount> skillAccount;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CertificateAccount> certificateAccounts;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EducationAccount> educationAccounts;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Experience> experiences;

    @OneToOne
    @JoinColumn(name = "JobTitleApplyID")
    private JobTitleApply JobTitleApply;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Project> projects;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TargetAccount> targetAccounts;


    public String show() {
        return "Account{" +
                "citizenCard='" + citizenCard + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", adress='" + adress + '\'' +
                ", image='" + image + '\'' +
                ", link='" + link + '\'' +
                ", gender='" + gender + '\'' +
                ", flag=" + flag +
                '}';
    }
}
