package com.example.profiles.core.admin.dtos.request;

import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectAdminRequest {
    private String projectName;
    private String jobTitle;
    private String fromDate;
    private String toDate;
    private String description;
}
