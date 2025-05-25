package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    SelenideElement userNameValue = $("input[name='name']");

    @Step("Открываем страницу профиля авторизованного пользователя")
    public ProfilePage openPage() {
        open("/user");
        return this;
    }

    @Step("Проверяем, что авторизовались в нужного пользователя")
    public ProfilePage assertThatNameOfUserIsCorrect(String userName) {
        userNameValue.shouldBe(visible).shouldHave(attribute("value", "Тимур Власов"));
        return this;
    }
}
