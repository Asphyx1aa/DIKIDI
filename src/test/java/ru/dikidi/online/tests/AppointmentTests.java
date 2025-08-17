package ru.dikidi.online.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.api.AppointmentSteps;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.online.pages.BookingWidgetPage;
import ru.dikidi.online.pages.CatalogPage;
import ru.dikidi.online.pages.CompanyPage;
import ru.dikidi.online.pages.RecordPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ru.dikidi.common.context.AuthContext.getAuthResponse;

@Owner("Тимур Власов")
@Feature("Запись")
@Tag("appointment")
@Tag("web")
class AppointmentTests extends WebTestBase {

    private final RecordPage recordPage = new RecordPage();
    private final CompanyPage companyPage = new CompanyPage();
    private final BookingWidgetPage bookingWidgetPage = new BookingWidgetPage();
    private final CatalogPage catalogPage = new CatalogPage();

    private final AppointmentSteps appointmentSteps = new AppointmentSteps();

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @DisplayName("Проверяем запись через сотрудника")
    void successfulCreateAppointmentFromMasterTest() {
        String token = getAuthResponse().path("data.token");
        final String companyUrl = config.getCompanyUrl();

        companyPage.openCompanyPage(companyUrl)
                .clickOnCreateAppointmentButton()
                .switchToIframe();

        bookingWidgetPage.makeAppointmentToMaster()
                .chooseMaster()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment()
                .checkBookingSuccessMessage();

        String bookingId = appointmentSteps.getAppointmentsOfUser(token);
        appointmentSteps.cancelBooking(token, bookingId);
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @DisplayName("Проверяем запись через услуги")
    void successfulCreateAppointmentFromServiceTest() {
        String token = getAuthResponse().path("data.token");
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

        String bookingId = appointmentSteps.getAppointmentsOfUser(token);
        appointmentSteps.cancelBooking(token, bookingId);
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @DisplayName("Проверяем запись из каталога")
    @Disabled("Сломан после редизайна каталога, надо править")
    void createAppointmentFromCatalogTest() {
        String token = getAuthResponse().path("data.token");
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

        String bookingId = appointmentSteps.getAppointmentsOfUser(token);
        appointmentSteps.cancelBooking(token, bookingId);
    }

    @WithLogin
    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверяем, что запись отменяется успешно")
    void successfulCancellingAppointmentTest() {
        recordPage.openPage()
                .clickOnCancelAppointment()
                .confirmCancellation();
    }
}
