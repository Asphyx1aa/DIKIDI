import config.TestsConfig;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Тимур Власов")
public class AuthorizationTests extends TestBase {

    MainPage mainPage = new MainPage();

    TestsConfig authData = ConfigFactory.create(TestsConfig.class);

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("authorization")
    })
    @DisplayName("Проверка успешной авторизации по номеру телефона")
    void successfulAuthorizationByNumber() {
        String userNumber = authData.getUserPhone();
        String userPassword = authData.getUserPassword();
        String userName = authData.getUserName();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .setUserNumber(userNumber)
                .setUserPassword(userPassword).clickOnUserProfile()
                .openProfilePage()
                .assertThatNameOfUserIsCorrect(userName);
    }
}
