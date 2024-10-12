package com.example.profiles.core.personally.dtos.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CertificateResponse {

    private String certificateID;
    private String certificateName;
    private String certificateImage;
    private Integer status;
}
