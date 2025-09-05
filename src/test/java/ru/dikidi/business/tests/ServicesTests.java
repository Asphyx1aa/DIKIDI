package ru.dikidi.business.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.dikidi.business.pages.Project.ServicePage;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.annotations.WithProject;
import ru.dikidi.common.api.ServicesSteps;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.common.data.ServiceData;
import ru.dikidi.common.enums.ProjectType;

import static ru.dikidi.common.context.ProjectContext.getProjectResponse;

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
    @WithProject(type = ProjectType.COMPANY)
    @DisplayName("Проверка создания услуги")
    void successfulCreateServiceTest() {
        ServiceData serviceData = ServiceData.fakeServiceData();
        String companyId = getProjectResponse().jsonPath().getString("data.id");

        servicePage.openPage(companyId)
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
}
