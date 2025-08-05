package ru.dikidi.business.pages.Project;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ServicePage {
    private final SelenideElement addServiceButton = $(".company-services .btn-primary"),
    personalServiceButton = $x("//a[contains(text(),'Персональная услуга')]"),
    serviceTitleInput = $("input[name='name']"),
    serviceDescrInput = $x("//textarea[@name='description']"),
    serviceCategoryButton = $("button[title='Не указано']"),
    serviceCategory = $x("//div[@class='head-settings']//li[3]//a[1]"),
    continueButtonServices = $x("//div[@class='tab service active']//button[@type='button'][contains(text(),'Далее')]"),
    continueButtonMaster = $x("//div[@class='tab masters active']//button[@type='button'][contains(text(),'Далее')]"),
    masterPicker = $x("//label[contains(text(),'Мастера ногтевого сервиса')]"),
    servicePriceInput = $$(".tab.active input[type='text']").get(1),
    confirmAddServiceButton = $x("//button[contains(text(),'Сохранить и закрыть')]");

    private final ElementsCollection companyServices = $$(".company-services-table tbody tr");


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
    public ServicePage addServiceTitle(String title) {
        $(".service.tab").shouldBe(visible);
        serviceTitleInput.setValue(title);
        return this;
    }

    @Step("Добавляем описание услуги")
    public ServicePage addServiceDescription(String title) {
        serviceDescrInput.setValue(title);
        return this;
    }

    @Step("Выбираем категорию услуги")
    public ServicePage chooseServiceCategory() {
        serviceCategoryButton.click();
        serviceCategory.shouldBe(visible).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Далее'")
    public ServicePage clickOnContinueButtonService() {
        continueButtonServices.shouldBe(visible).click();
        return this;
    }

    @Step("Выбираем мастера")
    public ServicePage chooseMasterPicker() {
        masterPicker.shouldBe(visible).click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Далее'")
    public ServicePage clickOnContinueButtonMaster() {
        continueButtonMaster.shouldBe(visible).click();
        return this;
    }

    @Step("Устанавливаем стоимость услуги")
    public ServicePage addServicePrice(double servicePrice) {
        servicePriceInput.shouldBe(visible).setValue(String.valueOf(servicePrice));
        return this;
    }

    @Step("Сохраняем услугу")
    public ServicePage saveService() {
        confirmAddServiceButton.click();
        return this;
    }

    @Step("Проверям, что услуга создалась корректно")
    public ServicePage verifyThatServiceIsCorrect(String serviceTitle, double servicePrice) {
        companyServices.shouldHave(sizeGreaterThan(0));
        companyServices.first().shouldHave(
                text(serviceTitle),
                text(String.valueOf(servicePrice))
        );
        return this;
    }
}
