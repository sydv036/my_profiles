package com.example.profiles.common;

import java.security.SecureRandom;

public class GenPrimaryKey {
    public static String getPrimaryKey(String key) {
        StringBuilder result = new StringBuilder(key);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            int valueRandom = random.nextInt(3);
            Character characterRandom;
            switch (valueRandom) {
                case 0:
                    characterRandom = (char) ('A' + random.nextInt(26));
                    break;
                case 1:
                    characterRandom = (char) ('a' + random.nextInt(26));
                    break;
                case 2:
                    characterRandom = (char) ('0' + random.nextInt(10));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + valueRandom);
            }
            result.append(characterRandom);
        }
        return result.toString();
    }
}
