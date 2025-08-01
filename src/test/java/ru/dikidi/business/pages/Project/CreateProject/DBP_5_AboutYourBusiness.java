package ru.dikidi.business.pages.Project.CreateProject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_5_AboutYourBusiness {


    private final SelenideElement
            //О вашем бизнесе
            //Есть ли филиалы (только у компании)
            Odin_filial = $x("//label[@for='one']"),
            neskolko = $x("//label[@for='more']"),
    //Количество сотрудников
    ot_2_do_5 = $x("//label[@for='small']"),
            ot_6_do_9 = $x("//label[@for='medium']"),
            ot_10 = $x("//label[@for='big']"),
    //Опыт
    first_experience = $x("//label[@for='first']"),
            Work_DIKIDI = $x("//label[@for='work']"),
            Work_v_drugom_meste = $x("//label[@for='change']"),
    //Откуда узнали о DIKIDI
    recomendation = $x("//label[@for='recomendation']"),
            reklama_v_internete = $x("//label[@for='ads']"),
            conference = $x("//label[@for='conf']"),
            dovno_znayu = $x("//label[@for='know']"),
            ne_pomnyu = $x("//label[@for='remember']");

    @Step("Указываем наличие одного филиала")
    public DBP_5_AboutYourBusiness Odin_filial() {
        Odin_filial.click();
        return this;
    }

    @Step("Указываем наличие нескольких филиалов")
    public DBP_5_AboutYourBusiness neskolko() {
        neskolko.click();
        return this;
    }

    @Step("Количество сотрудников от 2 до 5")
    public DBP_5_AboutYourBusiness ot_2_do_5() {
        ot_2_do_5.click();
        return this;
    }

    @Step("Количество сотрудников от 6 до 7")
    public DBP_5_AboutYourBusiness ot_6_do_9() {
        ot_6_do_9.click();
        return this;
    }

    @Step("Количество сотрудников от 10 и более")
    public DBP_5_AboutYourBusiness ot_10() {
        ot_10.click();
        return this;
    }

    @Step("Первый опыт использования похожих программ")
    public DBP_5_AboutYourBusiness first_experience() {
        first_experience.click();
        return this;
    }

    @Step("Работаю в DIKIDI")
    public DBP_5_AboutYourBusiness Work_DIKIDI() {
        Work_DIKIDI.click();
        return this;
    }

    @Step("Работаю в другом CRM")
    public DBP_5_AboutYourBusiness Work_v_drugom_meste() {
        Work_v_drugom_meste.click();
        return this;
    }

    @Step("Узнал из рекомендации")
    public DBP_5_AboutYourBusiness recomendation() {
        recomendation.click();
        return this;
    }

    @Step("Узнал из рекламы в интернете")
    public DBP_5_AboutYourBusiness reklama_v_internete() {
        reklama_v_internete.click();
        return this;
    }

    @Step("Конференции")
    public DBP_5_AboutYourBusiness conference() {
        conference.click();
        return this;
    }

    @Step("Знаю давно")
    public DBP_5_AboutYourBusiness dovno_znayu() {
        dovno_znayu.click();
        return this;
    }

    @Step("Не помню")
    public DBP_5_AboutYourBusiness ne_pomnyu() {
        ne_pomnyu.click();
        return this;
    }
}
