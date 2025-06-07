package api;

import io.qameta.allure.Step;
import models.AuthRequest;
import models.AuthResponse;

import static io.restassured.RestAssured.given;


public class AuthSteps {
    @Step("Получаем токен пользователя")
    public String getUserToken(String userNumber, String password) {

        AuthRequest authBody = new AuthRequest(userNumber, password);

        String token = given()
                .when()
                .body(authBody)
                .contentType("multipart/form-data")
                .multiPart("number", userNumber)
                .multiPart("password", password)
                .post("https://auth.test.dikidi.net/api/user/login")
                .then()
                .log().all()
                .extract()
                .path("data.token");

        return token;
    }
}
