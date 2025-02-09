package com.example.profiles.core.personally.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;


public interface EducationResponse {
    String getEducationID();

    String getEducationName();

    String getMajor();

    String getStartDate();

    String getEndDate();

    String getPoint();

    String getTranscript();
}
