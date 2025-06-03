package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class Servise {

    private final SelenideElement

            Photostudio = $x("//label[@for='services-52']"),
            Cleaning = $x("//label[@for='services-55']"),
            ServicesMassage = $x("//label[@for='services-19']"),
            Other = $x("//label[@for='services-27']"),
            Coworking = $x("//label[@for='services-54']"),
            Psychology = $x("//label[@for='services-56']");

    @Step("Специализация - Клининг")
    public Servise Cleaning() {
        Cleaning.click();
        return this;
    }

    @Step("Специализация - Массаж")
    public Servise Massage() {
        ServicesMassage.click();
        return this;
    }

    @Step("Специализация - Прочее")
    public Servise Other() {
        Other.click();
        return this;
    }

    @Step("Специализация - Коворкинг")
    public Servise Coworking() {
        Coworking.click();
        return this;
    }

    @Step("Специализация - Психология")
    public Servise Psychology() {
        Psychology.click();
        return this;
    }

    @Step("Специализация - Фотостудия")
    public Servise Photostudio() {
        Photostudio.click();
        return this;
    }

}
