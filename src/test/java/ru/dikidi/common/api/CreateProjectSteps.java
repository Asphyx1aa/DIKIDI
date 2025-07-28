package ru.dikidi.common.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static ru.dikidi.common.specs.AuthSpec.auth;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;

public class CreateProjectSteps {

    public static Response getCreateProject(String token) {
        return given()
                .spec(auth)
                .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
                .header("User-Agent", "DIKIDIBusiness/403 (6.4.6): Dalvik/2.1.0 (Linux; U; Android 15; SM-A546E Build/AP3A.240905.015.A2)")
                .contentType(ContentType.URLENC) // Тип тела x-www-form-urlencoded
                .formParam("country", "RU") // Параметр страны
                .formParam("type", "salon") // Компания,  отсутствие поля значит фрилансер
                .formParam("street", "улица Некрасова, 39б") // Улица
                .formParam("name", "DIKIDI AutoTESTs")  //Название
                .formParam("region_name_en", "Ярославская область") //Регион
                .formParam("city_name_loc", "Ярославль") //Город
                .formParam("company_info[1][0]", "1")
                .formParam("agreement", "1")
                .queryParam("token", token) // Токен авторизации GET
                .when()  // Отправка
                .post("https://api-beauty.dikidi.tech/registration/company")
                .then()  // Получение
                .log().all()
                .spec(baseResponseSpec(200))
                .extract()
                .response();
    }
}
