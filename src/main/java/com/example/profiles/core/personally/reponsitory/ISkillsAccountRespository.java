package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import com.example.profiles.repository.SkillAccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkillsAccountRespository extends SkillAccountRepository {


    @Query(value = """
                    select
                    	sk.id as skillsID,
                     	sk.skill_name  as SkillsName,
                     	skt.id as skillsTypeID,
                     	skt.skill_type_name as skillsTypeName                    
                    from
                    	skill_accounts ska
                    	left join skills sk ON ska.skillid = sk.id
                    	left join skill_types skt on sk.skill_typeid  = skt.id
                    	where ska.accountid = :citizenCard and sk.flag = 0
            """, nativeQuery = true)
    List<SkillsResponse> getSkillsOfProfileByCitizenCard(@Param("citizenCard") String citizenCard);
}
