package com.example.profiles.entity;

import com.example.profiles.base.BaseEntity;
import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.Set;

@Entity
@SQLDelete(sql="Update educations set flag = 1 where id = ?")
@Where(clause = "flag = 0")
@Table(name = "Educations")
@Getter
@Setter
public class Education extends BaseEntity {

    public Education() {
        super("EDU");
    }

    @Column(columnDefinition = "varchar(150)", nullable = false)
    private String educationName;
    private String startDate;
    private String endDate;
    private String point;
    private String major;
    @Column(columnDefinition = "longtext")
    private String transcript;
    @Column(columnDefinition = "bit", nullable = false)
    private Integer flag = FlagEnum.ACTIVE.ordinal();

    @OneToMany(mappedBy = "education", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EducationAccount> educationAccounts;


    public Education(String educationName, String startDate, String endDate, String point, String major, String transcript, Integer flag) {
        this.educationName = educationName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.point = point;
        this.major = major;
        this.transcript = transcript;
        this.flag = FlagEnum.ACTIVE.ordinal();
    }
}
