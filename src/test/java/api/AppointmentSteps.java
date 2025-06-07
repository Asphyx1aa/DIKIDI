package api;

import io.qameta.allure.Step;
import models.AppointmentResponse;
import tests.web.TestBase;

import static io.restassured.RestAssured.given;

public class AppointmentSteps extends TestBase {

    @Step("Получаем записи пользователя")
    public AppointmentResponse getAppointmentsOfUser(String token) {
        return given()
                .pathParam("token", token)
                .when()
                .get("https://test.dikidi.ru/api/user/bookings?token={token}")
                .then()
                .log().all()
                .extract()
                .as(AppointmentResponse.class);
    }
}
