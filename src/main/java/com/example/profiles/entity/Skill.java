package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Skills")
@Getter
@Setter
public class Skill extends BaseEntity {
    public Skill() {
        super("SKL");
    }

    private String skillName;
    @ManyToOne
    @JoinColumn(name = "skillTypeID")
    private SkillType skillType;

    @OneToMany(mappedBy = "skill", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SkillAccount> skillAccounts;

    public Skill(String skillName, SkillType skillType) {
        super("SKL");
        this.skillName = skillName;
        this.skillType = skillType;
    }
}
