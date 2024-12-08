package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Projects")
@Getter
@Setter
public class Project extends BaseEntity {
    public Project() {
        super("PRJ");
    }

    private String projectName;
    private String jobTitle;
    private String fromDate;
    private String toDate;
    @Column(columnDefinition = "LongText")
    private String description;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;

    public Project(String projectName, String jobTitle, String fromDate, String toDate, String description, Account account) {
        super("PRJ");
        this.projectName = projectName;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
//                ", description='" + description + '\'' +
                ", account=" + account.getCitizenCard() +
                '}';
    }
}
