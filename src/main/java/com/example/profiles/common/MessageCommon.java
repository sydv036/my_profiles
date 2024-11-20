package com.example.profiles.common;

import com.example.profiles.constant.MessageConstant;

public class MessageCommon {
    public static String getMessageByKey(String key) {
        return MessageConstant.MESSAGES.getOrDefault(key, "Unknown message code!");
    }
}
