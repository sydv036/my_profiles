package com.example.profiles.core.personally.dtos.response;

import com.example.profiles.entity.Certificate;
import com.example.profiles.entity.CertificateAccount;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;


@Projection(types = {Certificate.class, CertificateAccount.class})
public interface CertificateResponse {

    @Value("#{target.id}")
    String getCertificateID();

    @Value("#{target.certificateName}")
    String getCertificateName();

    @Value("#{target.duration}")
    String getDuration();

    @Value("#{target.certificateImage}")
    String getCertificateImage();

}
