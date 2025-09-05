package ru.dikidi.common.extensions;

import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import ru.dikidi.common.data.UserData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ru.dikidi.common.api.AuthSteps.getAuthorizationResponse;
import static ru.dikidi.common.context.AuthContext.setAuthResponse;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        final String FAVICON_URL = "https://dikidi.tech/favicon.svg";

        final String userNumber = UserData.fromConfig().getUserNumber();
        final String userPassword = UserData.fromConfig().getUserPassword();

        final Response authResponse = getAuthorizationResponse(userNumber, userPassword);
        final String cookieToken = authResponse.getCookie("token");

        setAuthResponse(authResponse);

        open(FAVICON_URL);

        // Преобразуем в Selenium Cookie
        final Cookie seleniumCookie = new Cookie.Builder("token", cookieToken)
                .domain("dikidi.tech")
                .path("/")
                .isHttpOnly(true)
                .isSecure(true)
                .build();

        getWebDriver().manage().addCookie(seleniumCookie);
    }
}