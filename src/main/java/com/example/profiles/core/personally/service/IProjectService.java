package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.ProjectResponse;

import java.util.List;

public interface IProjectService {
    List<ProjectResponse> getProjectByCitizenCard(String citizenCard) throws Exception;
}
