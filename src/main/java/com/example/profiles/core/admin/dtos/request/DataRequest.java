package com.example.profiles.core.admin.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataRequest {
    private String id;
    private String attrName;
    private String valueNew;
}