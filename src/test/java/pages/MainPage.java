package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement authButton = $(".authorization"),
            authByNumberButton = $(".modal-content").$(".number"),
            userNumberInput = $(".modal-content").$("#number"),
            userPasswordInput = $(".modal-content").$("[name='password']"),
            userProfileButton = $(".dropdown.user").$(".img-circle"),
            profileButton = $$(".dropdown-menu li").first();

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
        userNumberInput.setValue(userNumber);
        return this;
    }

    @Step("Вводим пароль в поле для ввода")
    public MainPage setUserPassword(String userPassword) {
        userPasswordInput.setValue(userPassword).pressEnter();
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
