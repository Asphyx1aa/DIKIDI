package ru.dikidi.common.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static ru.dikidi.common.helpers.CustomAllureListener.withCustomTemplates;

public class BaseSpec {
    public static final RequestSpecification baseSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body();


    public static ResponseSpecification baseResponseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}