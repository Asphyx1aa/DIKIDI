package ru.dikidi.online.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    private final SelenideElement userNameValue = $x("//input[@name='name']"),
            userEmailValue = $x("//input[@name='email']");

    @Step("Проверяем, что авторизовались в нужного пользователя")
    public ProfilePage assertThatLoginInCorrectUser(String userName, String userEmail) {
        userNameValue.shouldBe(visible).shouldHave(attribute("value", userName));
        userEmailValue.shouldBe(visible).shouldHave(attribute("value", userEmail));
        return this;
    }
}
