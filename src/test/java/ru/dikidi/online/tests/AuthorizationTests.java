package ru.dikidi.online.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import ru.dikidi.common.data.UserData;
import ru.dikidi.online.pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Авторизация / регистрация")
public class AuthorizationTests extends TestBase {

    private final MainPage mainPage = new MainPage();

    @BeforeEach
    void openAuthByPhone() {
        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber();
    }

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("smoke"),
            @Tag("authorization")
    })
    @DisplayName("Проверка успешной авторизации по номеру телефона")
    public void successfulAuthorizationByNumber() {
        UserData user = UserData.fromConfig();

        mainPage.fillAuthForm(user.getUserNumber(), user.getUserPassword())
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(user.getUserName());
    }

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("smoke"),
            @Tag("registration")
    })
    @DisplayName("Проверка успешной регистрации по номеру телефона")
    void successfulRegistrationByNumber() {
        UserData user = UserData.fakeUserData();

        mainPage.fillRegistrationForm(user.getUserNumber(), user.getUserName(), user.getUserMail(), user.getUserPassword()) // Нужен статичный код
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(user.getUserName());
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("smoke"),
            @Tag("authorization")
    })
    @DisplayName("Попытка авторизации с неправильным паролем")
    void incorrectPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Неверный логин или пароль";

        mainPage.fillAuthForm(user.getUserNumber(), "incorrect pw")
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("smoke"),
            @Tag("authorization")
    })
    @DisplayName("Попытка авторизации без ввода пароля")
    void emptyPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Нужно указать логин и пароль для авторизации";

        mainPage.setUserNumberWithoutPw(user.getUserNumber())
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("smoke"),
            @Tag("authorization")
    })
    @DisplayName("Проверка работы функции 'Забыли пароль?'")
    void forgotPasswordTest() {
        UserData userData = UserData.fromConfig();

        mainPage.setUserNumber(userData.getUserNumber())
                .clickOnForgotPass()
                .verifyThatRecoveryPassModalAppear(); // Нужен статичный код
    }
}
