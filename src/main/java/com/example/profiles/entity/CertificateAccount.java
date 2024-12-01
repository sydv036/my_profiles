package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CertificateAccounts")
@Getter
@Setter
public class CertificateAccount extends BaseEntity {

    public CertificateAccount() {
        super("CFA");
    }

    @ManyToOne
    @JoinColumn(name = "certificateID", nullable = true)
    private Certificate certificate;

    @ManyToOne
    @JoinColumn(name = "accountID", nullable = true)
    private Account account;

    public CertificateAccount(Certificate certificate, Account account) {
        super("CFA");
        this.certificate = certificate;
        this.account = account;
    }
}
