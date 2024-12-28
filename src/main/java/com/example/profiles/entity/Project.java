package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@SQLDelete(sql = "Update projects set flag = 1 where  id = ?")
@Where(clause = "flag = 0")
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
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag = FlagEnum.ACTIVE.ordinal();

    public Project(String projectName, String jobTitle, String fromDate, String toDate, String description, Account account) {
        super("PRJ");
        this.projectName = projectName;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.account = account;
        this.flag = FlagEnum.ACTIVE.ordinal();
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
