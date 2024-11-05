package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "TargetTypes")
@Getter
@Setter
public class TargetType extends BaseEntity {
    public TargetType() {
        super("TGT");
    }

    private int targetTypeName;

    @OneToMany(mappedBy = "targetType", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Target> targets;
}
