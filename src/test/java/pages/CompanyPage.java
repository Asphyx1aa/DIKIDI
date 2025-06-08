package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record^='/ru/record/']"),
            iframeForAppointment = $("iframe[src*='/ru/record/']"),
            CheckCreateCompany = $x("//h1[text()='Профиль']");

    @Step("Открываем профиль компании")
    public CompanyPage openCompanyPage(String companyId) {
        open("/ru/profile/" + companyId);
        return this;
    }

    @Step("Убираем баннер о куки")
    public CompanyPage removeCookieBanner() {
        executeJavaScript("document.getElementById('cookie-consent').remove()");
        return this;
    }

    @Step("Кликаем на кнопку 'Записаться'")
    public CompanyPage clickOnCreateAppointmentButton() {
        makeAppointmentButton.click();
        return this;
    }

    @Step("Переходим в iframe для записи")
    public CompanyPage switchToIframe() {
        removeCookieBanner();
        switchTo().frame(iframeForAppointment);
        return this;
    }

    @Step("Проверка url Профиля компании")
    public CompanyPage checkURL() {
        CheckCreateCompany.shouldBe(visible);
        return this;
    }
}
