package tests.web;

import annotations.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.BookingWidgetPage;
import pages.CompanyPage;
import pages.RecordPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Запись")
public class AppointmentsTests extends TestBase {

    private final RecordPage recordPage = new RecordPage();
    private final CompanyPage companyPage = new CompanyPage();
    private final BookingWidgetPage bookingWidgetPage = new BookingWidgetPage();

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
                .completeAppointment();
    }

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем, что запись к сотруднику работает корректно")
    void successfulCreateAppointmentTest() {
    @DisplayName("Проверяем запись через услуги")
    void successfulCreateAppointmentFromServiceTest() {
        final String companyUrl = config.getCompanyUrl();

        companyPage.openCompanyPage(config.getCompanyUrl())
        companyPage.openCompanyPage(companyUrl)
                .removeCookieBanner()
                .clickOnCreateAppointmentButton()
                .switchToIframe();

        bookingWidgetPage.makeAppointmentService()
                .chooseService()
                .chooseTimeForAppointment()
                .clickOnContinueButton()
                .completeAppointment();
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
