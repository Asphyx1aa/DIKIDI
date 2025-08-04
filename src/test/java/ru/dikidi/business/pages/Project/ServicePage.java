package ru.dikidi.business.pages.Project;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ServicePage {
    private final SelenideElement addServiceButton = $(".company-services .btn-primary"),
    personalServiceButton = $x("//a[contains(text(),'Персональная услуга')]"),
    serviceTitleInput = $("input[name='name']"),
    serviceCategoryButton = $("button[title='Не указано']"),
    serviceCategory = $x("//div[@class='head-settings']//li[3]//a[1]"),
    continueButton = $x("//div[@class='tab service active']//button[@type='button'][contains(text(),'Далее')]"),
    masterPicker = $x("//label[contains(text(),'Мастера ногтевого сервиса')]");

    @Step("Открываем страницу с услугами компании")
    public ServicePage openPage(String companyId) {
        open("owner/services/?company=" + companyId);
        return this;
    }

    @Step("Нажимаем на кнопку 'Добавить услугу'")
    public ServicePage clickOnAddServiceButton() {
        addServiceButton.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Персональная услуга'")
    public ServicePage clickOnPersonalServiceButton() {
        personalServiceButton.shouldBe(visible).click();
        return this;
    }

    @Step("Вводим название услуги")
    public ServicePage setServiceTitle(String title) {
        $(".service.tab").shouldBe(visible);
        serviceTitleInput.setValue(title);
        return this;
    }

    @Step("Выбираем категорию услуги")
    public ServicePage chooseServiceCategory() {
        serviceCategoryButton.click();
        serviceCategory.shouldBe(visible).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Далее'")
    public ServicePage clickOnContinueButton() {
        continueButton.shouldBe(visible).click();
        return this;
    }

    @Step("Выбираем мастера ногтевого сервиса")
    public ServicePage chooseMasterPicker() {
        masterPicker.shouldBe(visible).click();
        return this;
    }
}
