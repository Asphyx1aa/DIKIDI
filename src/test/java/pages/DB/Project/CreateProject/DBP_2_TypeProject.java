package pages.DB.Project.CreateProject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_2_TypeProject {


    //Тип

    private final SelenideElement Company = $x("//div[text()='Компания']"),

    Specialist = $x("//div[text()='Работаю самостоятельно']");


    @Step("Тип проекта - Компания")
    public DBP_2_TypeProject CreateCompany() {
        Company.click();
        return this;
    }

    @Step("Тип проекта - Специалист ")
    public DBP_2_TypeProject CreateSpecialist() {
        Specialist.click();
        return this;
    }

}
