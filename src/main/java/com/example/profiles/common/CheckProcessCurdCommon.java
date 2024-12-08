package com.example.profiles.common;

import com.example.profiles.enums.FlagCurdEnum;
import com.example.profiles.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class CheckProcessCurdCommon {
    public static boolean isCheckProcessCurd(FlagCurdEnum flg, Object obj) {
        try {
            if (Optional.ofNullable(obj).isEmpty()) {
                throw new CustomException(HttpStatus.BAD_REQUEST, MessageCommon.getMessageByKey("MES015T"));
            }
            switch (flg.ordinal()) {
                case 0: //PROCESS_CREATE
                    LogCommon.logInfo(MessageCommon.getMessageByKey("MES002T"));
                    return true;
                case 1: //PROCESS_UPDATE
                    LogCommon.logInfo(MessageCommon.getMessageByKey("MES005T"));
                    return true;
                case 2: //PROCESS_DELETE
                    LogCommon.logInfo(MessageCommon.getMessageByKey("MES006T"));
                    return true;
                case 3: //PROCESS_GET
                    LogCommon.logInfo(MessageCommon.getMessageByKey("MES012T"));
                    return true;
                default:
                    LogCommon.logError("MES014T");
                    return false;
            }
        } catch (CustomException e) {
            LogCommon.logError(e.getMessage());
            throw e;
        }
    }
}
