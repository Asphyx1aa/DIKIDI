package api;

import io.qameta.allure.Step;
import models.AppointmentResponse;

import static io.restassured.RestAssured.given;
import static specs.BaseSpec.baseResponseSpec;
import static specs.BaseSpec.baseSpec;

public class AppointmentSteps {

    @Step("Получаем записи пользователя")
    public String getAppointmentsOfUser(String token) {
        AppointmentResponse response = given()
                .spec(baseSpec)
                .pathParam("token", token)
                .when()
                .get("https://dikidi.tech/api/user/bookings?token={token}")
                .then()
                .spec(baseResponseSpec(200))
                .log().all()
                .extract()
                .as(AppointmentResponse.class);

        return response.getData().getList().getFirst().getId(); // Сократить цвпочку вызовов
    }

    @Step("Отменяем созданную запись через API")
    public void cancelBooking(String token, String bookingId) {
        given()
                .spec(baseSpec)
                .pathParam("token", token)
                .pathParam("bookingId", bookingId)
                .when()
                .get("https://dikidi.tech/api/booking/remove?token={token}&id={bookingId}")
                .then()
                .log().all()
                .spec(baseResponseSpec(200));
    }
}
