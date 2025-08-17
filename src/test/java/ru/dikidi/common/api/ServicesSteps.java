package ru.dikidi.common.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.dikidi.common.data.ServiceData;

import static io.restassured.RestAssured.given;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class ServicesSteps {
    @Step("Создаем услугу в проекте с данными: {serviceData}")
    public Response createService(ServiceData serviceData) {

        return given()
                .spec(baseSpec)
                .queryParam("token", "bf411ea9620d0384aee82347d68139b688e9acd1")
                .queryParam("company", "3554")
                .contentType("multipart/form-data")
                .log().all()
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .multiPart("name", serviceData.getServiceTitle())
                .multiPart("description", serviceData.getServiceDescription())
                .multiPart("cost", serviceData.getServicePrice())
                .multiPart("category", 23820    )
                .multiPart("floating", serviceData.isFloating() ? 1 : 0)
                .multiPart("online", serviceData.isOnline() ? 1 : 0)
                .multiPart("time", serviceData.getTime())
                .multiPart("break_duration", serviceData.getBreakDuration())
                .when()
                .post("https://api-beauty.dikidi.tech/office/services/save/")
                .then()
                .spec(baseResponseSpec(200))
                .log().all()
                .extract()
                .response();
    }

    @Step("Получаем все услуги компании")
    public Response getServices() {
        return given()
                .spec(baseSpec)
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .queryParam("token", "bf411ea9620d0384aee82347d68139b688e9acd1")
                .queryParam("company", "3554")
                .log().all()
                .when()
                .get("https://dikidi.tech/api/owner/services/list/")
                .then()
                .spec(baseResponseSpec(200))
                .extract()
                .response();
    }

    @Step("Удаляем услугу")
    public Response deleteService() {
        return given()
                .spec(baseSpec)
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .queryParam("token", "bf411ea9620d0384aee82347d68139b688e9acd1")
                .queryParam("company", "3554")
                .queryParam("id", "39829")
                .log().all()
                .when()
                .get("https://api-beauty.dikidi.tech/office/services/delete/")
                .then()
                .spec(baseResponseSpec(200))
                .extract()
                .response();
    }

}
