package com.utils.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratedRandomValues {

    public static String generateRandomEmail() {
        return getParamatherizedRandomString("mail", 4);
    }

    public static String generateRandomNumber() {
        return getRandomNumbers(6);
    }

    public static String generateRandomPassword() {
        return getRandomNumbers(6);
    }

    private static String getParamatherizedRandomString(String name, int count) {
        return String.format("%s%s%s", name, RandomStringUtils.randomAlphabetic(count), "@gmail.com");
    }

    public static String getRandomNumbers(int count) {
        return String.format(RandomStringUtils.randomNumeric(count));
    }
}
