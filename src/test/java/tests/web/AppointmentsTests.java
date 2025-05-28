package tests.web;

import data.UserData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CompanyPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Тимур Власов")
@Feature("Запись")
public class AppointmentsTests extends TestBase {

    final MainPage mainPage = new MainPage();
    final CompanyPage companyPage = new CompanyPage();

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Проверяем, что запись к сотруднику работает корректно")
    void successfulCreateAppointmentTest() {
        UserData user = UserData.fromConfig();

        mainPage.openPage()
                .removeCookieBanner()
                .clickOnAuthButton()
                .clickOnAuthNumber()
                .fillAuthForm(user.getUserNumber(), user.getUserPassword());

        sleep(2000); // Костыль, надо подумать как избавиться
        companyPage.openCompanyPage("kompashka_natashki_1684")
                .clickOnCreateAppointmentButton()
                .SwitchToIframe();
        sleep(10000);
    }
}
