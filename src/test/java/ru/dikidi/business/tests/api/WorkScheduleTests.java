package ru.dikidi.business.tests.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static io.restassured.RestAssured.given;
import static ru.dikidi.common.specs.BaseSpec.baseResponseSpec;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class WorkScheduleTests {

    List<Integer> masterIds;
    GregorianCalendar calendar = new GregorianCalendar();

    private void getAllMastersInCompany(String token, String company_id) {
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

        JsonPath jsonPath = new JsonPath(response);
        masterIds = jsonPath.getList("data.list.id");

        System.out.println("Master IDs: " + masterIds);
    }


    @Step("Заполнение полного графика работы для всех сотрудников в компании на месяц")
    public void fillWorkScheduleAllMasters(String token, String company_id) {
        getAllMastersInCompany(token, company_id);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        RequestSpecification request = RestAssured.given()
            .spec(baseSpec)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .header("Authorization", "0e3997b62d22a8237fecdd128ee8f2eea8853cbc")
            .queryParam("token", token)
            .queryParam("company", company_id);
        for (int j = 0; j <= 30; j++){
            String today = year + "-" + refactorDate(month) + "-" + refactorDate(day);
            day++;

            if(day > 30){ //TODO но тут не заполнится 31 число, если есть в месяце, если сильно важно, то придется делать проверку на количество дней в месяце
                month++;
                day = 1;
            }
            for(int x = 0; x < masterIds.size(); x++){
                String masterDate = "masters[" + masterIds.get(x) + "][" + today + "]";
                request.formParam(masterDate, today);
            }
        }
        ValidatableResponse response = request
                .formParam("work[end]", "18:00")
                .formParam("work[begin]", "08:00")
                .when()
                .post("https://api-beauty.dikidi.tech/office/schedules/timetable_edit")
                .then()
                .log().all()
                .spec(baseResponseSpec(200));

    }

    private String refactorDate(int var){
        int length = String.valueOf(Math.abs(var)).length();
        if(length == 1){
            String result = "0" + var;
            return result;
        } else {
            String result = "" + var;
            return result;
        }
    }
}
