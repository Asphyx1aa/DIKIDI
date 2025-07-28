package ru.dikidi.business.tests;

import org.junit.jupiter.api.Test;
import ru.dikidi.business.pages.Project.ServicePage;
import ru.dikidi.common.annotations.WithLogin;

public class ServicesTests extends TestBase {
    ServicePage servicePage = new ServicePage();

    @WithLogin
    @Test
    void successfulCreateServiceTest() {
        servicePage.openPage(config.getCompanyId())
                .clickOnAddServiceButton()
                .clickOnPersonalServiceButton()
                .setServiceTitle("test")
                .chooseServiceCategory();
    }
}
