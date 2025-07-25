package ru.dikidi.common.specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static ru.dikidi.common.specs.BaseSpec.baseSpec;

public class AuthSpec {
    public static final RequestSpecification auth = with()
            .spec(baseSpec);
}