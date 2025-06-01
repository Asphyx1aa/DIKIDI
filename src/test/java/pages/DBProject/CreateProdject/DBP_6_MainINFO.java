package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_6_MainINFO {
    private final SelenideElement

            //Основная информация
            FIO = $x("//input[@placeholder='Введите название компании']"),
            COUNTRY = $x("//span[@class='filter-option pull-left']"),
    //Очень много
    City = $x("//input[@class='form-control input-city filled']"),
            Street = $x("//input[@placeholder='Введите название компании']"),
            House = $x("//input[@placeholder='Введите название компании']"),
            Indecs = $x("//input[@placeholder='Введите название компании']"),
            Phones = $x("//input[@placeholder='Введите название компании']"),
            Promo_code = $x("//input[@placeholder='Введите название компании']"),
            Consent_checkbox = $x("uj"),
            User_agreement = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/202-polzovatelskoe-soglashenie']"),
            Privacy_policies = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/224-politika-konfidentsialnosti']"),
            Create_company = $x("//button[@class='action-btn new-elements-button blue success']");
}
