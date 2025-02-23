package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.entity.Target;

public interface ITargetAdminService {
    boolean saveOrUpdate(DataRequest dataRequest, int typeTarget) throws Exception;

    boolean deleteTarget(String id);

    Target getTargetById(String id);
}
