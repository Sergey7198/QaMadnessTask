package com.englishdom.scenarios;

import com.englishdom.helpers.data.GlobalTexts;
import com.englishdom.helpers.data.User;
import com.englishdom.utils.helpers.DriverHelpers;
import com.englishdom.utils.TestBase;
import com.englishdom.pages.MainPage;
import com.englishdom.pages.SignInForm;
import com.englishdom.utils.helpers.GeneratedRandomValues;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginFormTest extends TestBase {

    DriverHelpers driverHelpers = new DriverHelpers();

    private void waitForPageLoaded() {
        driverHelpers.waitUntilPageIsLoaded();
    }

    @Description("Check that existing user can login")
    @Test
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
    @Test
    void checkLoginWithRandomNonExistingCredentials() {
        MainPage mainPage = new MainPage();
        mainPage
                .openMainPage();
        waitForPageLoaded();
        mainPage
                .clickSignInButton()
                .assertAuthorizationModalIsDisplayed();
        SignInForm signInForm = new SignInForm();
        signInForm
                .fillInEmailField(GeneratedRandomValues.generateRandomEmail())
                .fillInPasswordField(GeneratedRandomValues.generateRandomNumber())
                .clickToLogin();
        assertThat(signInForm.getLoginErrorMessage()).contains(GlobalTexts.LOGIN_ERROR_MESSAGE.getMessage());
    }

    @Description("Check that user can not login with correct email but incorrect password")
    @Test
    void checkLogInWithIncorrectPassword() {
        User user = new User();

        MainPage mainPage = new MainPage();
        mainPage
                .openMainPage()
                .clickSignInButton();
        SignInForm signInForm = new SignInForm();
        signInForm
                .fillInEmailField(user.getEmail())
                .fillInPasswordField("777777777")
                .clickToLogin();
        assertThat(signInForm.getLoginErrorMessage()).contains(GlobalTexts.LOGIN_ERROR_MESSAGE.getMessage());
    }

}
