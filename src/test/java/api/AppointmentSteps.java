package api;

import io.qameta.allure.Step;
import models.AppointmentResponse;
import tests.web.TestBase;

import static io.restassured.RestAssured.given;
import static specs.BaseSpec.baseResponseSpec;
import static specs.BaseSpec.baseSpec;

public class AppointmentSteps extends TestBase {

    @Step("Получаем записи пользователя")
    public AppointmentResponse getAppointmentsOfUser(String token) {
        return given()
                .spec(baseSpec)
                .pathParam("token", token)
                .when()
                .get("https://test.dikidi.ru/api/user/bookings?token={token}")
                .then()
                .spec(baseResponseSpec(200))
                .extract()
                .as(AppointmentResponse.class);
    }

    @Step("Отменяем созданную запись")
    public void cancelBooking(String token, String bookingId) {
        given()
                .spec(baseSpec)
                .pathParam("token", token)
                .pathParam("bookingId", bookingId)
                .when()
                .get("https://test.dikidi.ru/api/booking/remove?token={token}&id={bookingId}")
                .then()
                .spec(baseResponseSpec(200));
    }
}
