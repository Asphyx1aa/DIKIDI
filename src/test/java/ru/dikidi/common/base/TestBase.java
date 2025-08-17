package ru.dikidi.common.base;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dikidi.common.config.TestsConfig;

public class TestBase {

    protected static final TestsConfig config = ConfigFactory.create(TestsConfig.class);
    protected static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void baseSetup() {
        log.info("Инициализация базовых настроек тестов");
        log.info("Загружена конфигурация: baseUrl={}", config.getBaseUrl());
    }
}