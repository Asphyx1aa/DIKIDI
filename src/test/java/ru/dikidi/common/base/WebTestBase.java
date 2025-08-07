package ru.dikidi.common.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.dikidi.common.helpers.Attach;

public abstract class WebTestBase extends TestBase {

    @BeforeAll
    protected static void webSetup() {
        log.info("Настройка конфигурации Selenide");
        Configuration.baseUrl = System.getProperty("baseUrl", config.getBaseUrl());
        Configuration.browserSize = System.getProperty("browserSize", config.getBrowserSize());
        Configuration.browser = System.getProperty("browser", config.getBrowser());
        Configuration.headless = true;
        log.info("Web конфигурация: baseUrl={}, browserSize={}, browser={}", 
                Configuration.baseUrl, Configuration.browserSize, Configuration.browser);
    }

    @BeforeEach
    protected void webBeforeEach() {
        log.info("Начало выполнения UI теста");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    protected void webAfterEach() {
        try {
            log.info("Завершение UI теста, добавление вложений");
            Attach.screenshotAs("Скриншот после теста");
            Attach.browserConsoleLogs();
        } catch (Exception e) {
            log.error("Ошибка при добавлении вложений в Allure: {}", e.getMessage());
        } finally {
            log.info("Закрытие браузера");
            Selenide.closeWebDriver();
        }
    }
}