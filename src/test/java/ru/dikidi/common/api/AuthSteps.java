package ru.dikidi.common.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static ru.dikidi.common.specs.AuthSpec.auth;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;


public class AuthSteps {

    @Step("Получаем токен пользователя")
    public static Response getUserAuth(String userNumber, String password) {
        return given()
                .when()
                .contentType("multipart/form-data")
                .multiPart("number", userNumber)
                .multiPart("password", password)
                .post("https://auth.dikidi.tech/api/user/login")
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
                .post("https://auth.dikidi.tech/ajax/user/auth")
                .then()
                .log().all()
                .body("callback", notNullValue())
                .spec(baseResponseSpec(200))
                .extract()
                .response();
    }
}
