package ru.dikidi.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dikidi.common.config.TestsConfig;
import ru.dikidi.common.helpers.Attach;

public class TestBase {

    protected final static TestsConfig config = ConfigFactory.create(TestsConfig.class);
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    protected static void testSetup() {
        Configuration.baseUrl = System.getProperty("baseUrl", config.getBaseUrl()) ;
        Configuration.browserSize = System.getProperty("browserSize", config.getBrowserSize());
        Configuration.browser = System.getProperty("browser", config.getBrowser());
    }

    @BeforeEach
    protected void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    protected void afterEach() {
        try {
            Attach.screenshotAs("Скриншот после теста");
            Attach.browserConsoleLogs();
        } catch (Exception e) {
            log.error("Ошибка при добавлении вложений в Allure", e.getMessage());
        } finally {
            Selenide.closeWebDriver();
        }
    }
}
