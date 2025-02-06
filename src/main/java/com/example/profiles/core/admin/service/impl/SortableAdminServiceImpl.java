package com.example.profiles.core.admin.service.impl;

import com.example.profiles.core.admin.repository.ISortableAdminRepository;
import com.example.profiles.core.admin.service.ISortableAdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service
@Transactional
public class SortableAdminServiceImpl implements ISortableAdminService {

    @Autowired
    private ISortableAdminRepository sortableAdminRepostory;

    @Override
    public boolean saveSortable(Map<String, String> sortable) {
        try {
            System.out.printf(Arrays.toString(sortable.keySet().toArray()));
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
