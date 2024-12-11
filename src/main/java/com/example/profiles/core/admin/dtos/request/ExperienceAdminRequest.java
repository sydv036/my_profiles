package com.example.profiles.core.admin.dtos.request;

import com.example.profiles.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExperienceAdminRequest {
    private String companyName;
    private String jobTitle;
    private String fromDate;
    private String toDate;
    private Account account;

    @Override
    public String toString() {
        return "ExperienceAdminRequest{" +
                "companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", account=" + account.getCitizenCard() +
                '}';
    }
}
