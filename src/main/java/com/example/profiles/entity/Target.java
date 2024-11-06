package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "Targets")
@Getter
@Setter
@NoArgsConstructor
public class Target extends BaseEntity {

    private String targetName;

    @ManyToOne
    @JoinColumn(name = "targetTypeID", nullable = true)
    private TargetType targetType;

    @OneToMany(mappedBy = "target", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TargetAccount> targetAccounts;


    public Target(String targetName, TargetType targetType) {
        super("TAR");
        this.targetName = targetName;
        this.targetType = targetType;
    }
}
