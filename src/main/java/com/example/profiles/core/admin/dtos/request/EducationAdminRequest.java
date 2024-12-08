package com.example.profiles.core.admin.dtos.request;

import com.example.profiles.enums.FlagEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationAdminRequest {
    private String educationName;
    private String startDate;
    private String endDate;
    private Float point;
    private String major;
    private String transcript;
    private Integer status = FlagEnum.ACTIVE.ordinal();
}
