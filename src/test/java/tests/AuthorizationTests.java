package tests;

import data.UserData;
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
public class AuthorizationTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Проверка успешной авторизации по номеру телефона")
    void successfulAuthorizationByNumber() {
        UserData user = UserData.fromConfig();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumber(user.getUserNumber())
                .setUserPassword(user.getUserPassword())
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
                .setUserNumber(user.getUserNumber())
                .setUserName(user.getUserName())
                .setUserEmail(user.getUserMail())
                .activateCheckBox()
                .setUserPassword(user.getUserPassword()) // Пока будет падать из-за необходимости ввести код ТГ
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

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumber(user.getUserNumber())
                .setUserPassword("random")
                .checkThatAlertShowed();
    }
}
