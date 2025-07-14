package tests.web;

import data.UserData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Авторизация / регистрация")
public class AuthorizationTests extends TestBase {

    private final MainPage mainPage = new MainPage();

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Проверка успешной авторизации по номеру телефона")
    public void successfulAuthorizationByNumber() {
        UserData user = UserData.fromConfig();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .fillAuthForm(user.getUserNumber(), user.getUserPassword())
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(user.getUserName());
    }

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("registration")
    })
    @DisplayName("Проверка успешной регистрации по номеру телефона")
    void successfulRegistrationByNumber() {
        UserData user = UserData.fakeUserData();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .fillRegistrationForm(user.getUserNumber(), user.getUserName(), user.getUserMail(), user.getUserPassword()) // Нужен статичный код
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(user.getUserName());
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Попытка авторизации с неправильным паролем")
    void incorrectPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Неверный логин или пароль";

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .fillAuthForm(user.getUserNumber(), "incorrect pw")
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Попытка авторизации без ввода пароля")
    void emptyPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Нужно указать логин и пароль для авторизации";

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumberWithoutPw(user.getUserNumber())
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Проверка работы функции 'Забыли пароль?'")
    void forgotPasswordTest() {
        UserData userData = UserData.fromConfig();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumber(userData.getUserNumber())
                .clickOnForgotPass()
                .verifyThatRecoveryPassModalAppear(); // Нужен статичный код
    }
}
