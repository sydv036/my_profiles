package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.ProjectAdminRequest;
import com.example.profiles.entity.Project;

public interface IProjectAdminService {
    boolean saveProject(ProjectAdminRequest projectAdminRequest);

    boolean updateProject(DataRequest dataRequest);

    boolean deleteProject(String id);

    Project getProjectById(String id);
}
