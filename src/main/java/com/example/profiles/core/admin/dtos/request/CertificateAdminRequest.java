package com.example.profiles.core.admin.dtos.request;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CertificateAdminRequest {
    private String certificateName;
    private String duration;
    private String certificateImage;

}
