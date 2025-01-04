package com.example.profiles.core.admin.service;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.entity.SysParam;
import org.springframework.data.repository.query.Param;

public interface ISysParamAdminService {
    SysParam getSysParamsByCitizenCardAndFunctionName(String citizenCard, String functionName);

    boolean updateSysParam(DataRequest dataRequest);
}
