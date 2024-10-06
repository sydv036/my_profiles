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
@SQLDelete(sql = "Update Account set flag = 1 where citizenCard= ?")
@SQLSelect(sql = "SELECT * FROM Account ac WHERE ac.flag = 0")
public class Account {
    @Id
    @Column(columnDefinition = "varchar(12)", nullable = false)
    private String citizenCard;
    @Column(columnDefinition = "nvarchar(150)", nullable = false)
    private String fullName;
    private LocalDate birthDate;
    @Column(columnDefinition = "varchar(100)")
    private String email;
    @Column(columnDefinition = "varchar(10)", nullable = false,unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "varchar(5000)")
    private String adress;
    @Column(columnDefinition = "Longtext")
    private String image;
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SkillAccount> skillAccount;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CertificateAccount> certificateAccounts;

    @OneToMany(mappedBy = "account", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EducationAccount> educationAccounts;
}
