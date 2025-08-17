package ru.dikidi.online.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.common.data.UserData;
import ru.dikidi.online.pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Авторизация / регистрация")
@Tag("web")
@Tag("smoke")
@Tag("authorization")
class AuthorizationTests extends WebTestBase {

    private final MainPage mainPage = new MainPage();

    @Nested
    @DisplayName("Тесты на авторизацию")
    class LoginTests {
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

        @ParameterizedTest(name = "Авторизация с номером {0} и паролем {1} → сообщение {2}")
        @Severity(CRITICAL)
        @CsvSource({
                "'79999999999', 'incorrect_pw', 'Неверный логин или пароль'",
                "'79999999999', '', 'Нужно указать логин и пароль для авторизации'",
        })
        void negativeAuthTests(String phone, String password, String expectedMessage) {
            mainPage.fillAuthForm(phone, password)
                    .checkThatAlertShowed(expectedMessage);
        }

        @Test
        @Severity(CRITICAL)
        @DisplayName("Попытка авторизации с несущуствующим номером телефона")
        void shouldOpenRegistrationFormTest() {
            String notRegisteredPhone = "79665551122";

            mainPage.setUserNumber(notRegisteredPhone)
                    .assertThatRegistrationFormOpened();
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

    @Nested
    @WithLogin
    @DisplayName("Тесты на выход из системы")
    class LogoutTests {
        @Test
        @Severity(CRITICAL)
        @DisplayName("Успешный выход из системы")
        void successfulLogoutFromAccount() {
            mainPage.openPage()
                    .clickOnUserProfile()
                    .clickOnLogoutButton()
                    .assertThatAuthButtonIsVisible();
        }
    }
}