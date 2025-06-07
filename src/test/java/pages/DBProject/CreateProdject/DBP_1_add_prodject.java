package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_1_add_prodject {

    //Создание нового проекта
    private final SelenideElement
            CreateNesw = $x("//div[@class='list-item add-company']"),
    // Получить доступ к проекту
    AccessProject = $x("//div[@class='list-item add-access']");


    @Step("Начала создания проекта - Создать новый проект")
    public DBP_1_add_prodject CreateNewProdject() {
        CreateNesw.click();
        return this;
    }

    @Step("Начала создания проекта - Получить доступ к проекту")
    public DBP_1_add_prodject AccessProject() {
        AccessProject.click();
        return this;
    }
}
