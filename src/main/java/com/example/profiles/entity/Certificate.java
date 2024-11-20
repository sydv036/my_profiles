package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Certificates")
@Getter
@Setter
public class Certificate extends BaseEntity {
    public Certificate() {
        super("CER");
    }

    @Column(columnDefinition = "varchar(150)", unique = true)
    private String certificateName;

    private String duration;

    @Column(columnDefinition = "LongText", nullable = true)
    private String certificateImage;

    @Column(columnDefinition = "bit")
    private Integer status;

    @OneToMany(mappedBy = "certificate", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CertificateAccount> certificateAccounts;

    public Certificate(String certificateName, String duration, Integer status) {
        super("CER");
        this.certificateName = certificateName;
        this.duration = duration;
        this.status = status;
    }


}
