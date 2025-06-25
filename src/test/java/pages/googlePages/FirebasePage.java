package pages.googlePages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FirebasePage {

    final SelenideElement
        addAppButton = $(""),
        androidAppButton = $(""),
        packageNameAppInput = $(""),
        appNicknameInput = $(""),
        registerAppButton = $(""),
        downloadJSON = $("");

    @Step("Открываем play.google")
    public FirebasePage openPlayGoogle() {
        open("https://console.firebase.google.com/u/1/project/brand-android---1390/overview");

        return this;
    }
}