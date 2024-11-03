package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.Account;
import com.example.profiles.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountAdminRepository extends AccountRepository {
    Account findAccountByCitizenCard(String citizenCard);
}
