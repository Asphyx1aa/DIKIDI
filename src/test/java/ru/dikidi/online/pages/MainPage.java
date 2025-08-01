package ru.dikidi.online.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    final SelenideElement authButton = $(".authorization"),
            authByNumberButton = $(".modal-content").$(".number"),
            userNumberInput = $(".modal-content").$("#number"),
            userPasswordInput = $(".modal-content").$("[name='password']"),
            userProfileButton = $(".dropdown.user").$(".img-circle"),
            profileButton = $$(".dropdown-menu li").first(),
            agreementCheckBox = $("#agreement"),
            userAgeCheckBox = $("#age"),
            userEmailInput = $("input[name='repeat_email']"),
            userNameInput = $(".form-group.name").$("input"),
            mainSearchField = $(".main-search").$("input[type='text']"),
            companyCard = $(".company.item"),
            alert = $(".modal-alert"),
            forgotPassButton = $(".forgot"),
            recoveryPassModal = $("div[data-type='recovery']");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Убираем баннер о куки")
    public MainPage removeCookieBanner() {
        executeJavaScript("document.getElementById('cookie-consent').remove()");
        return this;
    }

    @Step("Кликаем по кнопке 'Вход / регистрация'")
    public MainPage clickOnAuthButton() {
        authButton.click();
        return this;
    }

    @Step("Кликаем по кнопке авторизации через телефон'")
    public MainPage clickOnAuthNumber() {
        authByNumberButton.click();
        return this;
    }

    @Step("Заполняем форму авторизации")
    public MainPage fillAuthForm(String userNumber, String userPassword) {
        setUserNumber(userNumber);
        setUserPassword(userPassword);
        userPasswordInput.pressEnter();
        return this;
    }

    @Step("Заполняем поле 'Номер телефона'")
    public MainPage setUserNumber(String userNumber) {
        userNumberInput.shouldBe(visible).setValue(userNumber);
        return this;
    }

    @Step("Заполняем поле 'Номер телефона' и отправляем форму")
    public MainPage setUserNumberWithoutPw(String userNumber) {
        setUserNumber(userNumber);
        userNameInput.pressEnter();
        return this;
    }

    @Step("Заполняем поле 'Номер телефона'")
    public MainPage setUserPassword(String userPassword) {
        userPasswordInput.shouldBe(visible).setValue(userPassword);
        return this;
    }

    @Step("Кликаем по кнопке 'Забыли пароль?'")
    public MainPage clickOnForgotPass() {
        forgotPassButton.click();
        return this;
    }

    @Step("Проверяем, что появилась модальное окно для ввода кода подтвеждения")
    public MainPage verifyThatRecoveryPassModalAppear() {
        recoveryPassModal.shouldBe(visible);
        return this;
    }

    @Step("Заполняем форму регистрации и отправляем ее")
    public MainPage fillRegistrationForm(String userNumber, String userName, String userEmail, String userPassword) {
        userNumberInput.shouldBe(visible).setValue(userNumber);
        userNameInput.shouldBe(visible).setValue(userName);
        userEmailInput.shouldBe(visible).setValue(userEmail);
        agreementCheckBox.click();
        userAgeCheckBox.click();
        userPasswordInput.shouldBe(visible).setValue(userPassword).pressEnter();
        return this;
    }

    @Step("Проверяем, что появился алерт о том, что указан неверный пароль")
    public MainPage checkThatAlertShowed(String text) {
        alert.shouldBe(visible).shouldHave(text(text));
        return this;
    }

    @Step("Кликаем по профилю пользователя")
    public MainPage clickOnUserProfile() {
        userProfileButton.click();
        return this;
    }

    @Step("Переходим в профиль авторизованного пользователя")
    public ProfilePage openProfilePage() {
        ProfilePage profilePage = new ProfilePage();

        profileButton.click();
        return profilePage;
    }

    @Step("Вводим название проекта в строку поиска")
    public MainPage setValueInSearchField(String companyName) {
        mainSearchField.shouldBe(visible).setValue(companyName).pressEnter();
        return this;
    }

    @Step("Проверяем, что проект нашелся")
    public MainPage assertThatCorrectProjectWasFound(String companyName) {
        companyCard.shouldBe(visible).shouldHave(text(companyName));
        return this;
    }
}
