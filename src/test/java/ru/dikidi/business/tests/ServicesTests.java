package ru.dikidi.business.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.dikidi.business.pages.Project.ServicePage;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.api.ServicesSteps;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.common.data.ServiceData;

@Owner("Тимур Власов")
@Feature("Услуга")
@Tag("web")
@Tag("smoke")
@Tag("service")
class ServicesTests extends WebTestBase {
    ServicePage servicePage = new ServicePage();
    ServicesSteps servicesSteps = new ServicesSteps();

    @Test
    @WithLogin
    @DisplayName("Проверка создания услуги в проекте компании")
    void successfulCreateServiceTest() {
        ServiceData serviceData = ServiceData.fakeServiceData();

        servicePage.openPage(config.getCompanyId())
                .clickOnAddServiceButton()
                .clickOnPersonalServiceButton()
                .addServiceTitle(serviceData.getServiceTitle())
                .addServiceDescription(serviceData.getServiceDescription())
                .chooseServiceCategory()
                .clickOnContinueButtonService()
                .chooseMasterPicker()
                .clickOnContinueButtonMaster()
                .addServicePrice(serviceData.getServicePrice())
                .saveService()
                .verifyThatServiceIsCorrect(
                        serviceData.getServiceTitle(),
                        serviceData.getServicePrice()
                );


        servicesSteps.deleteService();
    }

    @Test
    @WithLogin
    @DisplayName("Проверка создания услуги в проекте фрилансера")
    void successfulCreateServiceFreelanceTest() {
        ServiceData serviceData = ServiceData.fakeServiceData();

        servicePage.openPage(config.getCompanyId())
                .clickOnAddServiceButton();
    }
}
