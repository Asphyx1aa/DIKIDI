package pages.DB.Project.CreateProject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_6_MainINFO {
    private final SelenideElement

            //Основная информация
            FIO = $x("//input[@placeholder='Введите название компании']"),
            COUNTRYs = $x("//span[@class='filter-option pull-left']"),
            City = $x("//input[@class='input-search']"),
            Street = $x("//input[@name='street']"),
            House = $x("//input[@name='house']"),
            Indecs = $x("//input[@name='zipcode']"),
            Cod_COUNTRY_Phone = $x("//div[@class='selected-flag']"),

    Phones = $x("/html/body/div[3]/div/div/div/div/form/div[7]/div[2]/div[2]/div[6]/div/table/tbody/tr/td[3]/input[1]"),
            Promo_code = $x("//input[@name='promo']"),
            Consent_checkbox = $("#conditions"),// JS  касыль
            User_agreement = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/202-polzovatelskoe-soglashenie']"),
            Privacy_policies = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/224-politika-konfidentsialnosti']"),
            Create_company = $x("//button[@class='action-btn new-elements-button blue success']");

    private SelenideElement COUNTRYChoice(int indexcount) {
        return $x(String.format("//li[@data-original-index='%d']", indexcount)).shouldBe(visible, Duration.ofSeconds(10));
    }


    private SelenideElement Phonecountrycodename(int code_country) {
        return $x(String.format("//li[@data-code='%d']", code_country)).shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Введите название компании ")
    public DBP_6_MainINFO FIO(String FIOtext) {
        FIO.setValue(FIOtext);
        return this;
    }

    @Step("Выбор страны")
    public DBP_6_MainINFO COUNTRY(int indexcount) {
        COUNTRYs.click();
        COUNTRYChoice(indexcount).click();
        return this;
    }

    @Step("Выбор Города")
    public DBP_6_MainINFO City(String cityname) {
        City.setValue(cityname);

        return this;
    }

    @Step("Указании улицы")
    public DBP_6_MainINFO Street(String Streettext) {
        Street.setValue(Streettext);
        return this;
    }

    @Step("Ввод названия дома")
    public DBP_6_MainINFO House(String Housetext) {
        House.setValue(Housetext);
        return this;
    }

    @Step("Ввод индекса")
    public DBP_6_MainINFO Indecs(String Indecstext) {
        Indecs.setValue(Indecstext);
        return this;
    }

    @Step("Ввод кода страны телефона")
    public DBP_6_MainINFO Code_Phones(int code_country) {
        Cod_COUNTRY_Phone.click();

        Phonecountrycodename(code_country).click();
        return this;
    }

    @Step("Ввод номера телефона")
    public DBP_6_MainINFO Phones(String Phonenumder) {
        Phones.setValue(Phonenumder);
        return this;
    }

    @Step("Ввод промокода")
    public DBP_6_MainINFO Promo_code(String Promo) {
        Promo_code.setValue(Promo);
        return this;
    }

    @Step("Кнопка Создать компанию")
    public DBP_6_MainINFO Create_company() {
        Create_company.click();
        return this;
    }

    @Step("Согласие на условия")
    public DBP_6_MainINFO Consent_checkbox() {
        executeJavaScript("document.querySelector('label[for=\"conditions\"]').click();");
        return this;
    }


}
