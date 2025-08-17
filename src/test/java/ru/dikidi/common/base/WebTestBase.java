package ru.dikidi.common.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.dikidi.common.helpers.Attach;

import java.util.Map;

import static ru.dikidi.common.helpers.EnvHelper.isRemote;

public class WebTestBase extends TestBase {

    @BeforeAll
    static void webSetup() {
        if (isRemote) {
            Configuration.remote = "http://localhost:4444/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

        Configuration.baseUrl = System.getProperty("baseUrl", config.getBaseUrl());
        Configuration.browserSize = System.getProperty("browserSize", config.getBrowserSize());
        Configuration.browser = System.getProperty("browser", config.getBrowser());
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", config.isHeadless()));

        log.info("Web конфигурация: baseUrl={}, browserSize={}, browser={}",
                Configuration.baseUrl, Configuration.browserSize, Configuration.browser);
    }

    @BeforeEach
    void webBeforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void webAfterEach() {
        try {
            Attach.screenshotAs("Скриншот после теста");
            Attach.browserConsoleLogs();
            if (isRemote) {
                Attach.addVideo();
            }
        } catch (Exception e) {
            log.error("Ошибка при добавлении вложений в Allure: {}", e.getMessage());
        } finally {
            SelenideLogger.removeListener("AllureSelenide");
            Selenide.closeWebDriver();
        }
    }
}