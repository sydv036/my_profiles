package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@SQLDelete(sql = "update experiences set flag = 1 where id = ?")
@Where(clause = "flag = 0")
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
    private String fromDate;
    private String toDate;
    @ManyToOne
    @JoinColumn(name = "accountID", nullable = true)
    private Account account;
    private Integer flag = FlagEnum.ACTIVE.ordinal();

    public Experience(String companyName, String jobTitle, String fromDate, String toDate, Account account) {
        super("EXP");
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.account = account;
        this.flag = FlagEnum.ACTIVE.ordinal();
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
