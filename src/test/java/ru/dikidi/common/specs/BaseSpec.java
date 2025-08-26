package ru.dikidi.common.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static ru.dikidi.common.helpers.CustomAllureListener.withCustomTemplates;

public class BaseSpec {
    public static final RequestSpecification baseSpec = with()
            .filter(withCustomTemplates())
            .contentType("multipart/form-data")
            .log().uri()
            .log().cookies()
            .log().method()
            .log().body();


    public static ResponseSpecification baseResponseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(LogDetail.ALL)
                .build();
    }
}