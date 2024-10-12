package com.example.profiles.core.personally.responsitory;

import com.example.profiles.core.personally.dtos.response.SkillsResponse;
import com.example.profiles.repository.SkillAccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkillsAccountResponsitory extends SkillAccountRepository {

    @Query(value = """
                    SELECT new com.example.profiles.core.personally.dtos.response.SkillsResponse(
                            sk.id,sk.skillName,skt.id,skt.skillTypeName
                    ) 
                    FROM SkillAccount ska 
                    left join Skill sk on ska.skill.id = sk.id
                    left join SkillType skt on sk.skillType.id = skt.id
                    where ska.account.citizenCard = :citizenCard
            """)
    List<SkillsResponse> getSkillsOfProfileByCitizenCard(@Param("citizenCard") String citizenCard);
}
