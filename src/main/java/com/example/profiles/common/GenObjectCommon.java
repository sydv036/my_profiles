package com.example.profiles.common;

import com.example.profiles.core.admin.dtos.request.DataRequest;

import java.lang.reflect.Field;

public class GenObjectCommon<T> {
    private final Class<T> objectClass;

    public GenObjectCommon(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    public T genObject(T obj, DataRequest dataRequest) throws NoSuchFieldException, IllegalAccessException {
        Field fields = objectClass.getDeclaredField(dataRequest.getAttrName());
        fields.setAccessible(true);
        fields.set(obj, dataRequest.getValueNew());
        return obj;
    }

}
