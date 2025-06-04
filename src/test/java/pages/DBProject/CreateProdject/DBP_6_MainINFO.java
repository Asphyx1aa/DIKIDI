package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

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
            Consent_checkbox = $("#conditions"),
            User_agreement = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/202-polzovatelskoe-soglashenie']"),
            Privacy_policies = $x("//a[@href='https://support.dikidi.app/ru/knowledge-bases/4/articles/224-politika-konfidentsialnosti']"),
            Create_company = $x("//button[@class='action-btn new-elements-button blue success']");


    @Step("Введите название компании ")
    public DBP_6_MainINFO FIO(String FIOtext){
        FIO.setValue(FIOtext);
      return this;
    };

    @Step("Указании улицы")
    public DBP_6_MainINFO Street(String Streettext){
        Street.setValue(Streettext);
        return this;
    };

    @Step("Ввод дома")
    public DBP_6_MainINFO House(String Housetext){
        House.setValue(Housetext);
        return this;
    };

    @Step("Ввод индекса")
    public DBP_6_MainINFO Indecs(String Indecstext){
        Indecs.setValue(Indecstext);
        return this;
    };

    @Step("Ввод номера телефона")
    public DBP_6_MainINFO Phones(String Phonenumder){
        Phones.setValue(Phonenumder);
        return this;
    };


    @Step("Ввод промокода")
    public DBP_6_MainINFO Promo_code(String Promo){
        Promo_code.setValue(Promo);
        return this;
    };

    public DBP_6_MainINFO Create_company(){
        Create_company.click();
        return this;
    };

    public DBP_6_MainINFO Consent_checkbox(){
        executeJavaScript("document.querySelector('label[for=\"conditions\"]').click();");

        return this;
    };


}
