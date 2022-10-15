package com.englishdom.utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    public static RemoteWebDriver driver;
    public static String testName;
    public DriverFactory driverFactory = new DriverFactory();

    @BeforeMethod(alwaysRun=true)
    public void setUpEnvironmentFromBaseTest( Method method) {
        testName = method.getName();
        driver = driverFactory.getDriverInstance();
        Configuration.reportsFolder = "target/screenshots";//screenshots are being saved in this folder automatically
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 50;
        Configuration.baseUrl = "https://www.englishdom.com/";
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()  {
        if (driver !=null) {
            driver.quit();
        }
    }
}
