
import TestData.UserData;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

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
        UserData userData = new UserData();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumber(userData.getUserNumber())
                .setUserPassword(userData.getUserPassword())
                .clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(userData.getUserName());
    }
}
