package tests.web;

import annotations.WithLogin;
import config.TestsConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CompanyPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Тимур Власов")
@Feature("Запись")
public class AppointmentsTests extends TestBase {

    final CompanyPage companyPage = new CompanyPage();
    final MainPage mainPage = new MainPage();
    TestsConfig config = ConfigFactory.create(TestsConfig.class);


    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем, что запись к сотруднику работает корректно")
    void successfulCreateAppointmentTest() {

        companyPage.openCompanyPage(config.getCompanyUrl())
                .clickOnCreateAppointmentButton()
                .switchToIframe()
                .makeAppointmentToMaster()
                .chooseMaster()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment();
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем, что запись отменяется успешно")
    void successfulCancellingAppointmentTest() {
        mainPage.openPage()
                .clickOnUserProfile()
                .clickOnMyAppointmentButton();
    }
}
