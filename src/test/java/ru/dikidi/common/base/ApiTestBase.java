package ru.dikidi.common.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase extends TestBase {

    @BeforeAll
    static void apiSetup() {
        log.info("Настройка конфигурации RestAssured");
        String apiBaseUrl = config.getBaseUrl() + "/api";
        RestAssured.baseURI = apiBaseUrl;
        log.info("API конфигурация: baseURI={}", RestAssured.baseURI);
    }
}