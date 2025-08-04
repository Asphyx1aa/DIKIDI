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
@Tag("web")
@Tag("smoke")
@Tag("authorization")
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
    @DisplayName("Проверка успешной авторизации по номеру телефона")
    void successfulAuthorizationByNumber() {
        UserData user = UserData.fromConfig();

        mainPage.fillAuthForm(user.getUserNumber(), user.getUserPassword())
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatLoginInCorrectUser(user.getUserName(), user.getUserMail());
    }

    @Test
    @Severity(BLOCKER)
    @DisplayName("Проверка успешной регистрации по номеру телефона")
    @Disabled("Нужен проверочный код")
    void successfulRegistrationByNumber() {
        UserData user = UserData.fakeUserData();

        mainPage.fillRegistrationForm(
                        user.getUserNumber(),
                        user.getUserName(),
                        user.getUserMail(),
                        user.getUserPassword()
                )
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatLoginInCorrectUser(user.getUserName(), user.getUserMail());
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Попытка авторизации с неправильным паролем")
    void incorrectPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Неверный логин или пароль";

        mainPage.fillAuthForm(user.getUserNumber(), "incorrect pw")
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Попытка авторизации без ввода пароля")
    void emptyPasswordTest() {
        UserData user = UserData.fromConfig();
        String errorMessage = "Нужно указать логин и пароль для авторизации";

        mainPage.setUserNumber(user.getUserNumber())
                .clickOnContinueButton()
                .checkThatAlertShowed(errorMessage);
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверка работы функции 'Забыли пароль?'")
    @Disabled("Нужен проверочный код")
    void forgotPasswordTest() {
        UserData userData = UserData.fromConfig();

        mainPage.setUserNumber(userData.getUserNumber())
                .clickOnForgotPass()
                .verifyThatRecoveryPassModalAppear();
    }
}
