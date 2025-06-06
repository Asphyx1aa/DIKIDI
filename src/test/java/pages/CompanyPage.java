package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.DBProject.CreateProdject.DBP_6_MainINFO;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record='/ru/record/3554']"),
            iframeForAppointment = $("iframe[src*='/ru/record/3554']"),
            CheckCreateCompany = $x("//h1[text()='Профиль']");

    @Step("Открываем профиль компании")
    public CompanyPage openCompanyPage(String companyId) {
        open("/ru/profile/" + companyId);
        return this;
    }

    @Step("Кликаем на кнопку Записаться")
    public CompanyPage clickOnCreateAppointmentButton() {
        makeAppointmentButton.click();
        return this;
    }

    @Step("Переходим в iframe")
    public CompanyPage switchToIframe() {
        switchTo().frame(iframeForAppointment);
        return this;
    }



    @Step("Проверка url Профиля компании")
    public CompanyPage CheckURL () {
        CheckCreateCompany.shouldBe(visible);
        return this;
    }
}
