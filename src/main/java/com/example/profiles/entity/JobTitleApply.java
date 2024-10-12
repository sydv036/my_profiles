package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "JobTitleApplys")
@Getter
@Setter
public class JobTitleApply extends BaseEntity {
    public JobTitleApply() {
        super("JTA");
    }

    private String jobTitleApplly;

    @OneToOne
    private Account account;
}
