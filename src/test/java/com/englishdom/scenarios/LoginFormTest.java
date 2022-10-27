package com.englishdom.scenarios;

import com.data.TestDataProvider;
import com.helpers.data.GlobalTexts;
import com.helpers.data.User;
import com.base.TestBase;
import com.pages.MainPage;
import com.pages.SignInForm;
import com.utils.helpers.GeneratedRandomValues;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import com.codeborne.selenide.WebDriverRunner;

import static org.assertj.core.api.Assertions.*;

public class LoginFormTest extends TestBase {

    @Description("Check that existing user can login")
    @Test(groups = {"LoginTests"})
    void checkThatExistingUserCanLogin() {
        User user = new User();

        MainPage mainPage = new MainPage();
        mainPage
                .openMainPage()
                .clickSignInButton();
        SignInForm signInForm = new SignInForm();
        signInForm
                .fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickToLogin();
        assertThat(mainPage.userIsLoggedIn()).isEqualTo(true);
    }

    @Description("Check that user can not login with random non-existing credentials")
    @Test(groups = {"LoginTests"}, dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    void checkLoginWithRandomNonExistingCredentials(String typeOfTest, String email, String password) {
        MainPage mainPage = new MainPage();
        mainPage
                .openMainPage();
        mainPage
                .clickSignInButton()
                .assertAuthorizationModalIsDisplayed();
        SignInForm signInForm =
                new SignInForm();
        signInForm
                .fillInEmailField(email)
                .fillInPasswordField(password)
                .clickToLogin();
        assertThat(signInForm.getLoginErrorMessage()).contains(GlobalTexts.LOGIN_ERROR_MESSAGE.getMessage());

    }

    @Description("Check that user can not login with correct email but incorrect password")
    @Test(groups = {"LoginTests"})
    void checkLogInWithIncorrectPassword() {
        User user = new User();

        MainPage mainPage = new MainPage();
        mainPage
                .openMainPage()
                .clickSignInButton();
        SignInForm signInForm = new SignInForm();
        signInForm
                .fillInEmailField(user.getEmail())
                .fillInPasswordField(GeneratedRandomValues.generateRandomPassword())
                .clickToLogin();
        assertThat(signInForm.getLoginErrorMessage()).contains(GlobalTexts.LOGIN_ERROR_MESSAGE.getMessage());
        System.out.println(WebDriverRunner.getWebDriver().getCurrentUrl());
    }

}
