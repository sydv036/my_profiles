package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.dtos.request.EducationAdminRequest;
import com.example.profiles.entity.Education;

public interface IEducationAdminService {
    boolean saveEducationAdmin(EducationAdminRequest educationAdminRequest);

    boolean updateEducationAdmin(DataRequest dataRequest);

    boolean deleteEducationAdmin(String id);

    Education getEducationById(String id);
}
