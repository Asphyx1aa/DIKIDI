package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

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







}
