package tests;

import data.UserData;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Тимур Власов")
public class AppointmentsTests {

    MainPage mainPage = new MainPage();

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
    }
}
