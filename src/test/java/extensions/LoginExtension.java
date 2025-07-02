package extensions;

import data.UserData;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static api.AuthSteps.getUserAuth;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static context.AuthContext.setAuthResponse;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        final String userNumber = UserData.fromConfig().getUserNumber();
        final String userPassword = UserData.fromConfig().getUserPassword();

        Response authResponse = getUserAuth(userNumber, userPassword);
        String cookieToken = authResponse.getCookie("token");

        setAuthResponse(authResponse);

        open("https://dikidi.tech/favicon.svg");

        // Преобразуем в Selenium Cookie
        Cookie seleniumCookie = new Cookie.Builder("token", cookieToken)
                .domain("dikidi.tech")
                .path("/")
                .isHttpOnly(true)
                .isSecure(true)
                .build();

        getWebDriver().manage().addCookie(seleniumCookie);
    }

}