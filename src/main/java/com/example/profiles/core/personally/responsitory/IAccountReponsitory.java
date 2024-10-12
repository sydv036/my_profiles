package com.example.profiles.core.personally.responsitory;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;
import com.example.profiles.repository.AccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountReponsitory extends AccountRepository {

    @Query(value = """
                    SELECT new com.example.profiles.core.personally.dtos.response.ProfileResponse(
                        ac.citizenCard, ac.fullName, ac.birthDate,ac.email,ac.phoneNumber,ac.adress,ac.image,ac.link,ac.flag
                    )
                    FROM Account ac
                    where ac.citizenCard = :citizenCard
            """)
    ProfileResponse getProfileByCitizenCard(@Param("citizenCard") String citizenCard);

}
