package ru.dikidi.business.pages.Project;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ServicePage {
    final SelenideElement addServiceButton = $(".company-services .btn-primary"),
    personalServiceButton = $x("//a[contains(text(),'Персональная услуга')]"),
    serviceTitleInput = $("input[name='name']"),
    serviceCategoryButton = $("button[title='Не указано']");

    @Step("Открываем страницу с услугами компании")
    public ServicePage openPage(String companyId) {
        open("owner/services/?company=" + companyId);
        return this;
    }

    @Step
    public ServicePage clickOnAddServiceButton() {
        addServiceButton.click();
        return this;
    }

    public ServicePage clickOnPersonalServiceButton() {
        personalServiceButton.shouldBe(visible).click();
        return this;
    }

    public ServicePage setServiceTitle(String title) {
        $(".service.tab").shouldBe(visible);
        serviceTitleInput.setValue(title);
        return this;
    }

    public ServicePage chooseServiceCategory() {
        serviceCategoryButton.click();
        return this;
    }
}
