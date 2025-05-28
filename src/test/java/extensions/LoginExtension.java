package extensions;

import data.UserData;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static models.AuthResponse.getTokenCookie;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        final String userNumber = UserData.fromConfig().getUserNumber();
        final String userPassword = UserData.fromConfig().getUserPassword();

        io.restassured.http.Cookie restAssuredCookie = getTokenCookie(userNumber, userPassword);

        open("/assets/images/star.png");

        // Преобразуем в Selenium Cookie
        Cookie seleniumCookie = new Cookie.Builder(restAssuredCookie.getName(), restAssuredCookie.getValue())
                .domain("test.dikidi.ru")
                .path("/")
                .isHttpOnly(restAssuredCookie.isHttpOnly())
                .isSecure(restAssuredCookie.isSecured())
                .build();

        getWebDriver().manage().addCookie(seleniumCookie);

    }

}