package ru.dikidi.common.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.dikidi.common.models.AuthResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static ru.dikidi.common.specs.AuthSpec.auth;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class AuthSteps {

    @Step("Авторизуемся в аккаунт пользователя через API")
    public AuthResponse loginInAccount(String url, String userNumber, String password) {
        return given()
                .spec(baseSpec)
                .multiPart("number", userNumber)
                .multiPart("password", password)
                .when()
                .post(url + "/api/user/login")
                .then()
                .spec(baseResponseSpec(200))
                .extract()
                .as(AuthResponse.class);
    }

    @Step("Выходим из аккаунта пользователя через API")
    public void logoutFromAccount(String url) {
        given()
                .spec(baseSpec)
                .get(url + "/api/user/logout")
                .then()
                .spec(baseResponseSpec(200));
    }

    @Step("Получаем ответ авторизации")
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

    @Step("Получаем токен из AuthResponse")
    public static String extractToken(AuthResponse authResponse) {
        if (authResponse == null || authResponse.getData() == null) {
            throw new IllegalStateException("AuthResponse или data равны null");
        }

        String token = authResponse.getData().getToken();
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("Токен отсутствует или пустой");
        }

        return token;
    }
}
