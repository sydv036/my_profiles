package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.ExperienceResponse;
import com.example.profiles.repository.ExperienceRepository;
import org.hibernate.annotations.SQLSelect;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@SQLSelect(sql = "Select e from Experience where flag = 0 ")
//@Where(clause = "flag = 0")
public interface IExperienceReposiroy extends ExperienceRepository {

    @Query(value = """
            select exp.id           as id,
                   exp.company_name as companyName,
                   exp.job_title    as jobTitle,
                   exp.from_date    as fromDate,
                   exp.to_date      as toDate
            from experiences exp
            where exp.accountid = :citizenCard and exp.flag = 0
            """, nativeQuery = true)
    List<ExperienceResponse> getExperienceByCitizenCard(@Param("citizenCard") String citizenCard);
}
