package com.example.profiles.core.personally.service;

import com.example.profiles.core.personally.dtos.response.ProfileResponse;

public interface IAccountSerice {
    ProfileResponse getProfileByCitizenCard(String citizenCard);
}
