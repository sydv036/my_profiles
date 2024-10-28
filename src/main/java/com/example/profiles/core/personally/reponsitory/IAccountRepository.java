package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.repository.AccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends AccountRepository {

    @Query(value = """
                    SELECT new com.example.profiles.core.personally.dtos.response.ProfileResponse(
                        ac.citizenCard, ac.fullName, ac.birthDate,ac.email,ac.phoneNumber,ac.adress,ac.image,ac.link,ac.gender,ac.flag,jtt.jobTitleApplly
                    )
                    FROM Account ac
                    join JobTitleApply jtt on ac.JobTitleApply.id = jtt.id
                    where ac.citizenCard = :citizenCard
            """)
    ProfileResponse getProfileByCitizenCard(@Param("citizenCard") String citizenCard);

}
