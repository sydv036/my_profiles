package com.example.profiles.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SyDV3
 * @birthday 2003_01_04
 * @date:
 */
public class MessageConstant {
    public static Map<String, String> MESSAGES;

    static {
        Map<String, String> messages = new HashMap<>();
//        T: Throw
//        S: Server
        messages.put("MES001T", "Can't get data!");
        messages.put("MES002T", "Save operation successfully!");
        messages.put("MES003T", "Save operation failed!");
        messages.put("MES004T", "Update operation failed!");
        messages.put("MES005T", "Update operation successfully!");
        messages.put("MES006T", "Delete operation successfully!");
        messages.put("MES007T", "Delete operation failed!");
        messages.put("MES008T", "Can't connect to database!");
        messages.put("MES001S", "Server error!");
//        Tránh việc thay đổi messages
        MESSAGES = Collections.unmodifiableMap(messages);
    }

}
