package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;

public interface ITargetAdminService {
    boolean saveOrUpdate(DataRequest dataRequest,int typeTarget) throws Exception;
}
