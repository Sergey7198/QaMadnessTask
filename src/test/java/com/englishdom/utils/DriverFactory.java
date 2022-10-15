package com.englishdom.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;


public class DriverFactory {

    public RemoteWebDriver getDriverInstance() {
        RemoteWebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/mac/chromedriver");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        return driver;

    }
}

