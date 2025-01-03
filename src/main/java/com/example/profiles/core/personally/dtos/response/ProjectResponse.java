package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.Project;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(types = {Project.class})
public interface ProjectResponse {

    @Value("#{target.id}")
    String getProjectID();

    @Value("#{target.projectName}")
    String getProjectName();

    @Value("#{target.jobTitle}")
    String getJobTitle();

    @Value("#{target.fromDate}")
//    @JsonFormat(pattern = "MM-yyyy")
    String getFromDate();

    @Value("#{target.toDate}")
//    @JsonFormat(pattern = "MM-yyyy")
    String getToDate();

    @Value("#{target.description}")
    String getDescription();

}
