package com.example.profiles.common;

import com.example.profiles.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class CheckIsNullCommon {
    public static Object isIdCheck(Object obj) {
        try {
            if (Optional.ofNullable(obj).isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES011T"));
            }
            return obj;
        } catch (Exception e) {
            e.getMessage();
            throw e;
        }

    }
}
