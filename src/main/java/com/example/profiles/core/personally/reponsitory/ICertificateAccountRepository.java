package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.CertificateResponse;
import com.example.profiles.repository.CertificateAccountRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICertificateAccountRepository extends CertificateAccountRepository {

    @Query(value = """ 
            select ctf.id,
                   ctf.certificate_name  as certificateName,
                   ctf.duration,
                   ctf.certificate_image as certificateImage
            from certificate_accounts ctfa
                     left join certificates ctf on ctfa.certificateid = ctf.id
            where ctfa.accountid = :citizenCard and flag = 0;
            """, nativeQuery = true)
    List<CertificateResponse> getCertificateByCitizenCard(@Param("citizenCard") String citizenCard);
}
