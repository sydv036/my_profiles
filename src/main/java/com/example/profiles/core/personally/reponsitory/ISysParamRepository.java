package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.repository.SysParamRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysParamRepository extends SysParamRepository {
    @Query(value = """
                select sys.value from sys_param sys
                where sys.citizen_card = :citizenCard and sys.function_name= :functionName;
            """,nativeQuery = true)
    String getValueByCitizenCardAAndFunctionName(@Param("citizenCard") String citizenCard,@Param("functionName") String functionName);
}
