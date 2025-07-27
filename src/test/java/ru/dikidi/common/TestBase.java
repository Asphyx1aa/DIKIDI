package ru.dikidi.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.dikidi.common.config.TestsConfig;
import ru.dikidi.common.helpers.Attach;

public class TestBase {

    final static TestsConfig config = ConfigFactory.create(TestsConfig.class);


    @BeforeAll
    static void testSetup() {
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browser = config.getBrowser();
    }


    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.browserConsoleLogs();
        Selenide.closeWebDriver();
    }


}
