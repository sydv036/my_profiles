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
                    select new com.example.profiles.core.personally.dtos.response.EducationResponse
                        (
                      edu.id ,edu.educationName,edu.major,edu.startDate,edu.endDate,edu.point,edu.transcript,edu.status
                        )                
                        from EducationAccount eduac
                         left join  Education edu on eduac.education.id = edu.id
                        where eduac.account.citizenCard = :citizenCard
            """)
    List<EducationResponse> getEducationByCitizenCard(@Param("citizenCard") String citizenCard);
}
