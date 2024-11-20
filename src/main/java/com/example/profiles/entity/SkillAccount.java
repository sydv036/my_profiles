package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SkillAccounts")
@Getter
@Setter
public class SkillAccount extends BaseEntity {

    public SkillAccount() {
        super("SKA");
    }

    @ManyToOne
    @JoinColumn(name = "skillID", nullable = true)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "accountID", nullable = true)
    private Account account;

    public SkillAccount(Skill skill, Account account) {
        super("SKA");
        this.skill = skill;
        this.account = account;
    }
}
