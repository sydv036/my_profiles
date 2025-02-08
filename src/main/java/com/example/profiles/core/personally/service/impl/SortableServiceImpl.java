package com.example.profiles.core.personally.service.impl;

import com.example.profiles.common.CheckIsNullCommon;
import com.example.profiles.constant.ValueConstant;
import com.example.profiles.core.personally.reponsitory.ISortableRepository;
import com.example.profiles.core.personally.service.ISortableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SortableServiceImpl implements ISortableService {

    @Autowired
    private ISortableRepository sortableRepository;

    @Override
    public String[] getListValues(String cityzendCard) {
        try {
            String values = sortableRepository.getValueByCityzenCard(cityzendCard);
            return Optional.ofNullable(values)
                    .map(item -> item.split(","))
                    .orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }
}
