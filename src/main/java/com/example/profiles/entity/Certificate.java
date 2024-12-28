package com.example.profiles.entity;


import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.CertificateEnum;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Set;

@Entity
@SQLDelete(sql = "Update certificates set flag = 1 where  id = ?")
@Where(clause = "flag = 0")
@Table(name = "Certificates")
@Getter
@Setter
public class Certificate extends BaseEntity {
    public Certificate() {
        super("CER");
    }

    @Column(columnDefinition = "varchar(150)")
    private String certificateName;

    private String duration;

    @Column(columnDefinition = "LongText", nullable = true)
    private String certificateImage;

    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag= FlagEnum.ACTIVE.ordinal();;

    @OneToMany(mappedBy = "certificate", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CertificateAccount> certificateAccounts;

    public Certificate(String certificateName, String duration) {
        super("CER");
        this.certificateName = certificateName;
        this.duration = duration;
        this.flag = FlagEnum.ACTIVE.ordinal();
    }
}
