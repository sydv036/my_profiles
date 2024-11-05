package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TargetAccounts")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class TargetAccount extends BaseEntity {
    public TargetAccount() {
        super("TGA");
    }

    @ManyToOne
    @JoinColumn(name = "targetID")
    private Target target;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;

}
