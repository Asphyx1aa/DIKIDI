package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Servise {

    private final SelenideElement

            Photostudio = $x("//label[@for='services-52']"),
            Cleaning = $x("//label[@for='services-55']"),
            ServicesMassage = $x("//label[@for='services-19']"),
            Other = $x("//label[@for='services-27']"),
            Coworking = $x("//label[@for='services-54']"),
            Psychology = $x("//label[@for='services-56']"),
            BACK = $x("//button[@class='action-btn new-elements-button-outline blue back']"),
            Continue = $x("//button[@class='action-btn new-elements-button blue next']");


    @Step("Специализация - Клининг")
    public specialization_Servise Cleaning() {
        Cleaning.click();
        return this;
    }

    @Step("Специализация - Массаж")
    public specialization_Servise Massage() {
        ServicesMassage.click();
        return this;
    }

    @Step("Специализация - Прочее")
    public specialization_Servise Other() {
        Other.click();
        return this;
    }

    @Step("Специализация - Коворкинг")
    public specialization_Servise Coworking() {
        Coworking.click();
        return this;
    }

    @Step("Специализация - Психология")
    public specialization_Servise Psychology() {
        Psychology.click();
        return this;
    }

    @Step("Специализация - Фотостудия")
    public specialization_Servise Photostudio() {
        Photostudio.click();
        return this;
    }

    @Step("Специализация - продолжить")
    public specialization_Servise Continue() {
        Continue.click();
        return this;
    }

}
