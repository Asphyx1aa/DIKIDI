package ru.dikidi.online.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {
    final SelenideElement iframeForAppointment = $("iframe[src*='/record/']");

    public CatalogPage openPage() {
        open("/catalog");
        return this;
    }

    public CatalogPage clickOnBookingButton(String companyId) {
        final SelenideElement makeBookingButton = $("[data-record='/record/" + companyId);
        makeBookingButton.shouldBe(visible).click();
        return this;
    }

    @Step("Переходим в iframe для записи")
    public CatalogPage switchToIframe() {
        switchTo().frame(iframeForAppointment);
        return this;
    }
}
