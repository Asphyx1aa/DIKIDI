package tests.web;

import annotations.WithLogin;
import api.AppointmentSteps;
import api.AuthSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import pages.*;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Запись")
public class AppointmentTests extends TestBase {

    private final AuthSteps authSteps = new AuthSteps();
    private final RecordPage recordPage = new RecordPage();
    private final CompanyPage companyPage = new CompanyPage();
    private final BookingWidgetPage bookingWidgetPage = new BookingWidgetPage();
    private final CatalogPage catalogPage = new CatalogPage();

    private final AppointmentSteps appointmentSteps = new AppointmentSteps();

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем запись через сотрудника")
    void successfulCreateAppointmentFromMasterTest() {
        final String companyUrl = config.getCompanyUrl();

        companyPage.openCompanyPage(companyUrl)
                .removeCookieBanner()
                .clickOnCreateAppointmentButton()
                .switchToIframe();

        bookingWidgetPage.makeAppointmentToMaster()
                .chooseMaster()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment()
                .checkBookingSuccessMessage();

        String token = authSteps.getUserToken(config.getUserPhone(), config.getUserPassword()); // Подумать как убрать дублирующее получение токена

        appointmentSteps.getAppointmentsOfUser(token);
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем запись через услуги")
    void successfulCreateAppointmentFromServiceTest() {
        final String companyUrl = config.getCompanyUrl();

        companyPage.openCompanyPage(companyUrl)
                .removeCookieBanner()
                .clickOnCreateAppointmentButton()
                .switchToIframe();

        bookingWidgetPage.makeAppointmentService()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment()
                .checkBookingSuccessMessage();
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем запись из каталога")
    void createAppointmentFromCatalogTest() {
        String companyId = config.getCompanyId();

        catalogPage.openPage()
                .clickOnBookingButton(companyId)
                .switchToIframe();

        bookingWidgetPage.makeAppointmentToMaster()
                .chooseMaster()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment()
                .checkBookingSuccessMessage();
    }

    @WithLogin
    @Test
    @Severity(CRITICAL)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем, что запись отменяется успешно")
    void successfulCancellingAppointmentTest() {
        recordPage.openPage()
                .clickOnCancelAppointment()
                .confirmCancellation();
    }
}
