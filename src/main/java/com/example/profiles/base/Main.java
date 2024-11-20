package com.example.profiles.base;

import com.example.profiles.common.LogCommon;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        LogCommon.startLog();
        System.out.println("123");
        LogCommon.logInfo("start");
        LogCommon.endLog();
    }
}
