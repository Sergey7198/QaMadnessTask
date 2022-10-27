package com.data;

import com.utils.helpers.GeneratedRandomValues;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "validLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][]{
                {"invalid1", GeneratedRandomValues.generateRandomEmail(), GeneratedRandomValues.generateRandomPassword()},
                {"invalid2", GeneratedRandomValues.generateRandomEmail(), GeneratedRandomValues.generateRandomPassword()}
        };
    }
}
