package ru.dikidi.common.api;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class ProjectSteps {
//    @Step("Создаем проект через API")
//    public static void createProject(String token) {
//        given()
//                .spec(baseSpec)
//                .pathParam("token", token)
//                .multiPart("type", 1)
//                .multiPart("name", "Testoviy")
//                .multiPart("country", "RU")
//                .multiPart("city", 468902)
//                .multiPart("conditions", 1)
//                .multiPart("agreement_ad", 1)
//                .when()
//                .post("https://dikidi.tech/api/company/create?token={token}")
//                .then()
//                .spec(baseResponseSpec(200));
//    }

    @Step("Удаляем проект через API")
    public void deleteProject(int projectId) {
        given()
                .spec(baseSpec)
                .pathParam("company", projectId)
                .when()
                .post("https://dikidi.tech/business/ajax/projects/delete_company/")
                .then()
                .spec(baseResponseSpec(200));
    }
}
