package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_1_add_prodject {

    //Создание нового проекта
    private final SelenideElement CreateNesw = $x("//div[@class='list-item add-company']"),
    // Получить доступ к проекту
    AccessProject = $x("//div[@class='list-item add-access']");

}
