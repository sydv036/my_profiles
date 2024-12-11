package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.ExperienceAdminRequest;
import com.example.profiles.entity.Experience;

public interface IExperienceAdminService {

    boolean createExperience(ExperienceAdminRequest experienceAdminRequest);

    boolean updateExperience(DataRequest dataRequest);

    Experience getExperienceByID(String id);
}
