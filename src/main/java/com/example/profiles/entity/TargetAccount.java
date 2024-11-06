package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TargetAccounts")
@Getter
@Setter
@NoArgsConstructor
public class TargetAccount extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "targetID",nullable = false)
    private Target target;

    @ManyToOne
    @JoinColumn(name = "accountID",nullable = false)
    private Account account;

    public TargetAccount(Target target, Account account) {
        super("TGA");
        this.target = target;
        this.account = account;
    }
}
