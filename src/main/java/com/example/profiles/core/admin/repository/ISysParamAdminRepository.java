package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.SysParam;
import com.example.profiles.repository.SysParamRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysParamAdminRepository extends SysParamRepository {

    @Query(value = """
            select sys.*
            from sys_param sys
            where sys.citizen_card = :citizenCard
              and sys.function_name = :functionName
            """, nativeQuery = true)
    SysParam getSysParamsByCitizenCardAndFunctionName(@Param("citizenCard") String citizenCard, @Param("functionName") String functionName);
}
