package ru.dikidi.common.extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CreateprojectExtension implements BeforeEachCallback {

//    @Override
    public void beforeEach(ExtensionContext context) {

//        final String userNumber = UserData.fromConfig().getUserNumber();
//        final String userPassword = UserData.fromConfig().getUserPassword();
//
//        Response authResponse = getUserAuth(userNumber, userPassword);
//        String cookieToken = authResponse.getCookie("token");
//
//        setAuthResponse(authResponse);
//
//        open("https://dikidi.tech/favicon.svg");
//
//        // Преобразуем в Selenium Cookie
//        Cookie seleniumCookie = new Cookie.Builder("token", cookieToken)
//                .domain("dikidi.tech")
//                .path("/")
//                .isHttpOnly(true)
//                .isSecure(true)
//                .build();
//
//        getWebDriver().manage().addCookie(seleniumCookie);
    }

}