package com.helpers.data;

public enum GlobalTexts {
    LOGIN_ERROR_MESSAGE("The email or password that you entered is incorrect");

    private final String message;

    GlobalTexts(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
