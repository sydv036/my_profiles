package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EducationAccounts")
@Getter
@Setter
public class EducationAccount extends BaseEntity {
    public EducationAccount() {
        super("EDA");
    }

    @ManyToOne
    @JoinColumn(name = "educationID", nullable = true)
    private Education education;

    @ManyToOne
    @JoinColumn(name = "accountID", nullable = true)
    private Account account;

    public EducationAccount(Education education, Account account) {
        super("EDA");
        this.education = education;
        this.account = account;
    }
}
