package ru.dikidi.business.tests.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import ru.dikidi.common.models.AppointmentResponse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static io.restassured.RestAssured.given;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class SharesTest {

    @Step("Получение информации о акции")
    public void getShareById(String token, String company_id) {
        String response = RestAssured
                .given()
                .spec(baseSpec)
                .header("Content-Type", "application/json")
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .queryParam("token", token)
                .queryParam("company", company_id)
                .when()
                .get("https://dikidi.tech/api/owner/workers/list/")
                .then()
                .log().all()
                .extract()
                .asString();
    }

    @Step("Получение списка акций")
    public void getSharesList(String token, String company_id) {
        String response = RestAssured
                .given()
                .spec(baseSpec)
                .header("Content-Type", "application/json")
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .queryParam("token", token)
                .queryParam("company", company_id)
                .when()
                .get("https://dikidi.tech/api/owner/shares/list/")
                .then()
                .log().all()
                .extract()
                .asString();
    }

    @Step("Получение списка акций")
    public void postShareCreate(String token, String company_id) {
        String response = RestAssured
                .given()
                .spec(baseSpec)
                .header("Content-Type", "application/json")
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .queryParam("token", token)
                .queryParam("company", company_id)
                .when()
                .get("https://dikidi.tech/api/owner/shares/list/")
                .then()
                .log().all()
                .extract()
                .asString();
    }
}
