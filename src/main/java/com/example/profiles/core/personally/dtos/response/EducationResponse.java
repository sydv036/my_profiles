package com.example.profiles.core.personally.dtos.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EducationResponse {
    private String educationID;
    private String educationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Float point;
    private String transcript;
    private Integer status;
}
