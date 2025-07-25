package ru.dikidi.business.tests.api;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ru.dikidi.common.config.TestsConfig;

public class TestBase {
    final static TestsConfig config = ConfigFactory.create(TestsConfig.class);

    @BeforeAll
    static void testSetup() {
        RestAssured.baseURI = "https:///api";
    }
}
