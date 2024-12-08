package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Experiences")
@Getter
@Setter
public class Experience extends BaseEntity {
    public Experience() {
        super("EXP");
    }

    @Column(columnDefinition = "varchar(150)")
    private String companyName;
    private String jobTitle;
    private LocalDate fromDate;
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "accountID", nullable = true)
    private Account account;

    public Experience(String companyName, String jobTitle, LocalDate fromDate, LocalDate toDate, Account account) {
        super("EXP");
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", account=" + account.getCitizenCard() +
                '}';
    }
}
