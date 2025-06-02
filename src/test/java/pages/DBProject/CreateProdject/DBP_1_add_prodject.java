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

    String FULL_URL = "https://test.dikidi.ru/ru/business/projects";
    //Создание нового проекта
    private final SelenideElement
            CreateNew = $x("//button[@class='new-elements-button blue create-promotions']"),
            CreateNesw = $x("//div[@class='list-item add-company']"),
    // Получить доступ к проекту
    AccessProject = $x("//div[@class='list-item add-access']");



    @Step("Открываем страницу проекта")
    public DBP_1_add_prodject openPage() {
        open(FULL_URL);
        return this;
    }

    @Step("Начала создания проекта - Добавить новый")
    public DBP_1_add_prodject CreateProject() {
        CreateNew.click();
        return this;
    }

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
