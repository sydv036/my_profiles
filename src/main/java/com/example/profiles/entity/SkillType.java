package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "SkillTypes")
@Getter
@Setter
public class SkillType extends BaseEntity {

    public SkillType() {
        super("SKT");
    }

    private String skillTypeName;

    @OneToMany(mappedBy = "skillType", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Skill> skills;

    public SkillType(String skillTypeName) {
        this.skillTypeName = skillTypeName;
    }


}
