package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.TargetResponse;
import com.example.profiles.repository.TargetAccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITargetAccountRepository extends TargetAccountRepository {

//    @Query(value = """
//                select tg.id,tg.target_name as targetName, tgt.id, tgt.target_type_name as targetTypeName
//                from target_accounts tga
//                left join targets tg on tga.targetid = tg.id
//                left join target_types tgt on tg.target_typeid = tgt.id
//                where tga.accountid = :citizenCard
//            """, nativeQuery = true)
//    List<TargetResponse> getTargetByCitizenCard(@Param("citizenCard") String citizenCard);

    @Query(value = """
                select new com.example.profiles.core.personally.dtos.response.TargetResponse
                 (tg.id,tg.targetName, tgt.id, tgt.targetTypeName)
                from TargetAccount tga
                left join Target tg on tga.target.id = tg.id
                left join TargetType tgt on tg.targetType.id = tgt.id
                where tga.account.citizenCard = :citizenCard and tg.flag = 0
            """)
    List<TargetResponse> getTargetByCitizenCard(@Param("citizenCard") String citizenCard);

}
