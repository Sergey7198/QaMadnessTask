package com.englishdom.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInForm {

    private final SelenideElement emailField = $(".phn__user-login-action__field-email");
    private final SelenideElement passwordField = $(".phn__user-login-action__field-password");
    private final SelenideElement submitLoginButton = $(".phn__user-login-action__btn-enter");
    private final SelenideElement loginErrors = $$("#phn-login-form .error-item").filter(Condition.visible).get(0);


    @Step
    public SignInForm fillInEmailField(String email) {
        emailField.shouldBe(Condition.enabled).val(email);
        emailField.shouldHave(Condition.value(email));
        return this;
    }

    @Step
    public SignInForm fillInPasswordField(String password) {
        passwordField.shouldBe(Condition.enabled).val(password);
        passwordField.shouldHave(Condition.value(password));
        return this;
    }

    @Step
    public SignInForm clickToLogin() {
        submitLoginButton.click();
        return this;
    }

    @Step
    public String getLoginErrorMessage() {
        return loginErrors.waitUntil(Condition.visible, 5000).text();
    }

}
