package models;

import groovy.transform.SourceURI;
import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static specs.AuthSpec.auth;
import static specs.BaseSpec.baseResponseSpec;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

    @Step("Авторизуемся в аккаунт пользователя через API")
    public static Response getAuthorizationResponse(String userNumber, String password) {

        AuthRequest authBody = new AuthRequest(userNumber, password);

        return given()
                .spec(auth)
                .body(authBody)
                .contentType("multipart/form-data")
                .multiPart("number", userNumber)
                .multiPart("password", password)
                .when()
                .post("https://auth.test.dikidi.ru/ajax/user/auth")
                .then()
                .log().all()
                .body("callback", notNullValue())
                .spec(baseResponseSpec(200))
                .extract()
                .response();
    }

    @Step("Получаем куки для авторизации")
    public static Cookie getTokenCookie(String userNumber, String password) {
        Response response = getAuthorizationResponse(userNumber, password);
        Cookie tokenCookie = response.getDetailedCookie("token");

        System.out.println(tokenCookie);

        if (tokenCookie != null) {
            return tokenCookie;
        }

        throw new RuntimeException("Куки не получена");
    }
}
