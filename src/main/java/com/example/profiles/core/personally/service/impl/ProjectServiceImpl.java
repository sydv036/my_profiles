package com.example.profiles.core.personally.service.impl;

import com.example.profiles.core.personally.dtos.response.ProjectResponse;
import com.example.profiles.core.personally.reponsitory.IProjectRepository;
import com.example.profiles.core.personally.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public List<ProjectResponse> getProjectByCitizenCard(String citizenCard) throws Exception {
        try {
            List<ProjectResponse> projectResponseList = projectRepository.getProjectByCitizenCard(citizenCard);
            return projectResponseList;
        } catch (Exception e) {
            throw new Exception("Could not get project: " + e.getMessage());
        }
    }
}
