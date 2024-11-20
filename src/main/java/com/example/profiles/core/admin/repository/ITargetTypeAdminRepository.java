package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.TargetType;
import com.example.profiles.repository.TargetTypeRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITargetTypeAdminRepository extends TargetTypeRepository {
    TargetType getTargetTypeByTargetTypeName(int targetTypeName);
}
