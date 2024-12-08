package com.example.profiles.common;

import com.example.profiles.core.admin.dtos.request.DataRequest;
import com.example.profiles.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Field;

public class GenObjectCommon<T> {
    private final Class<T> objectClass;

    public GenObjectCommon(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    public T genObject(T obj, DataRequest dataRequest){
        LogCommon.startLog();
        try {
            Field fields = objectClass.getDeclaredField(dataRequest.getAttrName());
            fields.setAccessible(true);
            fields.set(obj, dataRequest.getValueNew());
            return obj;
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        } catch (IllegalAccessException e) {
            LogCommon.logError(e.getMessage());
            e.printStackTrace();
            throw new CustomException(HttpStatus.BAD_GATEWAY, e.getMessage());
        } catch (NoSuchFieldException e) {
            LogCommon.logError(e.getMessage());
            e.printStackTrace();
            throw new CustomException(HttpStatus.BAD_GATEWAY, e.getMessage());
        } finally {
            LogCommon.endLog();
        }
    }

}
