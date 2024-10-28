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
    private LocalDate fromDate;
    private LocalDate toDate;
    @Column(columnDefinition = "LongText")
    private String description;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;
}
