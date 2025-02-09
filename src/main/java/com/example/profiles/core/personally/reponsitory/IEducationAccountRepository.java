package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.EducationResponse;
import com.example.profiles.repository.EducationAccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEducationAccountRepository extends EducationAccountRepository {

    @Query(value = """
                    select
                    	edu.id as educationID,
                    	edu.education_name as educationName,
                    	edu.major as major,
                    	edu.start_date as startDate,
                    	edu.end_date as endDate,
                    	edu.`point` as point,
                    	edu.transcript as transcript
                    from
                    	education_accounts eda
                    left join educations edu on
                    	eda.educationid = edu.id
                    where
                    	eda.accountid = :citizenCard
                    	and edu.flag = 0
            """, nativeQuery = true)
    List<EducationResponse> getEducationByCitizenCard(@Param("citizenCard") String citizenCard);
}
