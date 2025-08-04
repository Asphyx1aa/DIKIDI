package ru.dikidi.business.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.dikidi.business.pages.Project.ServicePage;
import ru.dikidi.common.annotations.WithLogin;

@Owner("Тимур Власов")
@Feature("Услуга")
@Tag("web")
@Tag("smoke")
@Tag("service")
public class ServicesTests extends TestBase {
    ServicePage servicePage = new ServicePage();

    @WithLogin
    @Test
    @DisplayName("Проверка создания услуги")
    void successfulCreateServiceTest() {
        servicePage.openPage(config.getCompanyId())
                .clickOnAddServiceButton()
                .clickOnPersonalServiceButton()
                .setServiceTitle("test")
                .chooseServiceCategory()
                .clickOnContinueButton()
                .chooseMasterPicker();
    }
}
