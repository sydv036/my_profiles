package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Targets")
@Getter
@Setter
public class Target extends BaseEntity {
    public Target() {
        super("TAR");
    }

    private String targetName;

    @ManyToOne
    @JoinColumn(name = "targetTypeID", nullable = true)
    private TargetType targetType;

    @OneToMany(mappedBy = "target", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TargetAccount> targetAccounts;
}
