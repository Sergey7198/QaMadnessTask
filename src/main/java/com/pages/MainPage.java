package com.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import com.helpers.data.config.Config;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement signInButton = $$("[data-type='login']").filter(Condition.visible).get(0);
    private final SelenideElement authorizationModal = $(".content-popup");
    private final SelenideElement userAvatar = $(".phn__user-part__xp-avatar");

    @Step
    public MainPage openMainPage() {
        return Selenide.open(Config.getEnvironmentURL("test"), MainPage.class);
    }

    @Step
    public MainPage clickSignInButton() {
        signInButton.shouldBe(Condition.enabled).click();
        return this;
    }

    @Step
    public MainPage assertAuthorizationModalIsDisplayed() {
        authorizationModal.waitUntil(Condition.visible, 5000);
        return this;
    }

    @Step
    public boolean userIsLoggedIn() {
        boolean loggedIn = userAvatar.isDisplayed();
        if (!loggedIn) {
            userAvatar.waitUntil(Condition.visible, 7000);
        } else {
            Selenide.refresh();
        }
        return userAvatar.isDisplayed();
    }

}
