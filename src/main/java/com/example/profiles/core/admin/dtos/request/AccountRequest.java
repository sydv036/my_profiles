package com.example.profiles.core.admin.dtos.request;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountRequest {
    private String citizenCard;
    private String fullName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
    private String email;
    private String image;
    private String link;
    private Integer flag;
}
