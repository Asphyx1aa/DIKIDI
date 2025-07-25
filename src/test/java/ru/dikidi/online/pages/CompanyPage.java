package ru.dikidi.online.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record^='/ru/record/']"),
            iframeForAppointment = $("iframe[src*='/ru/record/']"),
            CheckCreateCompany = $x("//h1[text()='Профиль']");

    @Step("Открываем профиль компании")
    public CompanyPage openCompanyPage(String companyId) {
        open("/profile/" + companyId);
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
        switchTo().frame(iframeForAppointment);
        return this;
    }

    @Step("Проверка url Профиля компании")
    public String checkURL() {
        CheckCreateCompany.shouldBe(visible);
        String currentURL = url();
        return currentURL.split("=")[1];  // Просто возвращаем цифры


    }
}
