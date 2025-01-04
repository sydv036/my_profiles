package com.example.profiles.core.admin.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.common.CheckProcessCurdCommon;
import com.example.profiles.common.GenObjectCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.core.admin.repository.ISysParamAdminRepository;
import com.example.profiles.core.admin.service.IAccountAdminService;
import com.example.profiles.core.admin.service.ISysParamAdminService;
import com.example.profiles.entity.Account;
import com.example.profiles.entity.SysParam;
import com.example.profiles.enums.FlagCurdEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysParamAdminServiceImpl implements ISysParamAdminService {

    @Autowired
    private ISysParamAdminRepository sysParamAdminRepository;

    @Autowired
    private IAccountAdminService accountAdminService;

    /**
     * @param citizenCard
     * @param functionName
     * @return
     */
    @Override
    public SysParam getSysParamsByCitizenCardAndFunctionName(String citizenCard, String functionName) {
        try {
            CheckIsNullCommon.isIdCheck(citizenCard);
            CheckIsNullCommon.isIdCheck(functionName);
            SysParam sysParam = sysParamAdminRepository.getSysParamsByCitizenCardAndFunctionName(citizenCard, functionName);
            CheckIsNullCommon.isIdCheck(sysParam);
            return sysParam;
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * @param dataRequest
     * @return
     */
    @Override
    public boolean updateSysParam(DataRequest dataRequest) {
        try {
            CheckIsNullCommon.isIdCheck(dataRequest);
            SysParam sysParam = getSysParamsByCitizenCardAndFunctionName(ValueConstant.CITIZENCARD_CONST, dataRequest.getId());
            sysParam = new GenObjectCommon<>(SysParam.class).genObject(sysParam, dataRequest);
            Object object = sysParamAdminRepository.saveAndFlush(sysParam);
            return CheckProcessCurdCommon.isCheckProcessCurd(FlagCurdEnum.PROCESS_UPDATE, object);
        } catch (Exception e) {
            throw e;
        }
    }
}
