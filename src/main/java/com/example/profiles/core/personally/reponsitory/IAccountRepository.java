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
                        ac.citizenCard, ac.fullName, ac.birthDate,ac.email,ac.phoneNumber,ac.adress,ac.image,ac.link,ac.gender,ac.flag,ac.jobTitleApplly
                    )
                    FROM Account ac
                    where ac.citizenCard = :citizenCard
            """)
    ProfileResponse getProfileByCitizenCard(@Param("citizenCard") String citizenCard);
//    @Query(value = """
//                    select
//                    	ac.citizen_card as citizenCard,
//                    	ac.full_name as fullName,
//                    	ac.birth_date as birthDate,
//                    	ac.email ,
//                    	ac.phone_number as phoneNumber,
//                    	ac.adress ,
//                    	ac.image ,
//                    	ac.link ,
//                    	ac.gender ,
//                    	ac.flag ,
//                    	ac.job_title_applly as jobTitleApplly
//                    from
//                    	accounts ac
//                    where
//                    	ac.citizen_card = :citizenCard
//            """, nativeQuery = true)
//    ProfileResponse getProfileByCitizenCard(@Param("citizenCard") String citizenCard);
}
