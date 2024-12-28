package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Entity
@SQLDelete(sql = "Update targets set flag = 1 where id = ?")
@Where(clause = "flag = 0")
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
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag = FlagEnum.ACTIVE.ordinal();


    public Target(String targetName, TargetType targetType) {
        super("TAR");
        this.targetName = targetName;
        this.targetType = targetType;
        this.flag = FlagEnum.ACTIVE.ordinal();
    }
}
