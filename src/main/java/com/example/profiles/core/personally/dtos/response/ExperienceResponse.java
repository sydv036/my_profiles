package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.Experience;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(types = {Experience.class})
public interface ExperienceResponse {

    @Value("#{target.id}")
    String getExperienceID();

    @Value("#{target.companyName}")
    String getCompanyName();

    @Value("#{target.jobTitle}")
    String getJobTitle();

    @Value("#{target.fromDate}")
//    @JsonFormat(pattern = "MM-yyyy")
    String getFromDate();

    @Value("#{target.toDate}")
//    @JsonFormat(pattern = "MM-yyyy")
    String getToDate();
}
