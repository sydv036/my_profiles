package com.example.profiles.core.personally.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String major;
//    @JsonFormat(pattern = "MM-yyyy")
    private String startDate;
//    @JsonFormat(pattern = "MM-yyyy")
    private String endDate;
    private String point;
    private String transcript;
    private Integer status;
}
