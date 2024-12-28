package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.util.Set;

@Entity
@SQLDelete(sql = "Update skills set flag = 1 where  id = ?")
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
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag = FlagEnum.ACTIVE.ordinal();

    public Skill(String skillName, SkillType skillType) {
        super("SKL");
        this.skillName = skillName;
        this.skillType = skillType;
        this.flag = FlagEnum.ACTIVE.ordinal();
    }
}
