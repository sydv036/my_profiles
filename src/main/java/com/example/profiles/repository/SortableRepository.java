package com.example.profiles.repository;

import com.example.profiles.entity.Account;
import com.example.profiles.entity.Sortable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortableRepository extends JpaRepository<Sortable, String> {
}
