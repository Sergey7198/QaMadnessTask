package com.englishdom.utils.helpers;

import com.englishdom.utils.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DriverHelpers extends TestBase {

    @Step
    public DriverHelpers assertUrlContains(String url) {
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        return this;
    }

    @Step
    public DriverHelpers  waitUntilPageIsLoaded() {
        new WebDriverWait(driver, 5000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
