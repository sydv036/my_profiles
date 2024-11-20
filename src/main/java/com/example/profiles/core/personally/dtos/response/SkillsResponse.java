package com.example.profiles.core.personally.dtos.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SkillsResponse {
    private String skillsID;
    private String SkillsName;
    private String skillsTypeID;
    private int skillsTypeName;
}
