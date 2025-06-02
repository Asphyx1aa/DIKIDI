package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_2_TypeProject {


    //Тип

    private final  SelenideElement  Company = $x("//div[text()='Компания']"),

    Specialist= $x("//div[text()='Работаю самостоятельно']");

}
