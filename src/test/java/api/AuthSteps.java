package api;

import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import models.AuthResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static specs.AuthSpec.auth;
import static specs.BaseSpec.baseResponseSpec;


public class AuthSteps {

    @Step("Получаем токен пользователя")
    public static Response getUserAuth(String userNumber, String password) {
        return given()
                .when()
                .contentType("multipart/form-data")
                .multiPart("number", userNumber)
                .multiPart("password", password)
                .post("https://auth.test.dikidi.net/api/user/login")
                .then()
                .body("data.token", notNullValue())
                .log().all()
                .extract()
                .response();
    }

    @Step("Авторизуемся в аккаунт пользователя через API")
    public static Response getAuthorizationResponse(String userNumber, String password) {

        return given()
                .spec(auth)
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
