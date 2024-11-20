package com.example.profiles.common;

import org.apache.log4j.Logger;

public class LogCommon {
    private static Logger LOGGER_INFO = Logger.getLogger("InfoLog");
    private static Logger LOGGER_ERROR = Logger.getLogger("ErrorLog");

    public static void logInfo(String message) {
        LOGGER_INFO.info(message);
    }

    public static void logError(String message) {
        LOGGER_ERROR.error(message);
    }

    public static void startLog() {
        String methodName = getCurrentMethodName();
        LOGGER_INFO.info(String.format("START %s", methodName));
    }

    public static void endLog() {
        String methodName = getCurrentMethodName();
        LOGGER_INFO.info(String.format("End %s ", methodName));
    }

    private static String getCurrentMethodName() {
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        /*
        2: là getStackTrace
        3: là getCurrentMethodName
        4: phương thức gọi
         */
        return traceElements[3].getMethodName();
    }
}
