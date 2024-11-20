package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;

public interface ISkillAdminService {
    boolean saveOrUpdate(DataRequest dataRequest,int type);


}
