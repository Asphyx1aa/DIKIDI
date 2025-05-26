package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement authButton = $(".authorization"),
            authByNumberButton = $(".modal-content").$(".number"),
            userNumberInput = $(".modal-content").$("#number"),
            userPasswordInput = $(".modal-content").$("[name='password']"),
            userProfileButton = $(".dropdown.user").$(".img-circle"),
            profileButton = $$(".dropdown-menu li").first(),
            agreementCheckBox = $("#agreement"),
            userAgeCheckBox = $("#age"),
            userEmailInput = $("input[name='repeat_email']"),
            registrationButton = $("form[action='https://auth.test.dikidi.ru/ajax/check/number/']").$(".btn-auth"),
            userNameInput = $(".form-group.name").$("input");

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

    @Step("Вводим номер телефона в поле для ввода")
    public MainPage setUserNumber(String userNumber) {
        userNumberInput.shouldBe(visible).setValue(userNumber);
        return this;
    }

    @Step("Вводим пароль в поле для ввода")
    public MainPage setUserPassword(String userPassword) {
        userPasswordInput.shouldBe(visible).setValue(userPassword).pressEnter();
        return this;
    }

    @Step("Вводим имя пользователя")
    public MainPage setUserName(String userName) {
        userNameInput.shouldBe(visible).setValue(userName);
        return this;
    }

    @Step("Вводим email пользователя")
    public MainPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    @Step("Отмечаем чекбоксы для регистрации")
    public MainPage activateCheckBox() {
        agreementCheckBox.click();
        userAgeCheckBox.click();
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
}
