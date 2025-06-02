package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Owner("Никулин Дима")
@Feature("Создание проекта")
public class DBP_3_SphereActivities {
    private final SelenideElement

            Servise = $x("//div[@data-name='services']"),
            Beauty = $x("//div[@data-name='beauty']"),
            Healing = $x("//div[@data-name='health']"),
            Sport = $x("//div[@data-name='sport']"),
            Rent = $x("//label[@data-name='rent-2']"),
            Pet = $x("//div[@data-name='pets']"),
            Car = $x("//div[@data-name='auto']"),
            Game = $x("//div[@data-name='recreation']"),
            Education = $x("//div[@data-name='education']"),
            Restaurants = $x("//div[@data-name='food']");

    @Step("Сфера деятельности - Услуга ")
    public DBP_3_SphereActivities Servise() {
        Servise.click();
        return this;
    }

    @Step("Сфера деятельности - Красота ")
    public DBP_3_SphereActivities Beauty() {
        Beauty.click();
        return this;
    }

    @Step("Сфера деятельности - Здоровье ")
    public DBP_3_SphereActivities Healing() {
        Healing.click();
        return this;
    }

    @Step("Сфера деятельности - Спорт ")
    public DBP_3_SphereActivities Sport() {
        Sport.click();
        return this;
    }

    @Step("Сфера деятельности - Аренда ")
    public DBP_3_SphereActivities Rent() {
        Rent.click();
        return this;
    }

    @Step("Сфера деятельности - Животные ")
    public DBP_3_SphereActivities Pet() {
        Pet.click();
        return this;
    }

    @Step("Сфера деятельности - Авто ")
    public DBP_3_SphereActivities Car() {
        Car.click();
        return this;
    }

    @Step("Сфера деятельности - Развлечения ")
    public DBP_3_SphereActivities Game() {
        Game.click();
        return this;
    }

    @Step("Сфера деятельности - Образование ")
    public DBP_3_SphereActivities Education() {
        Education.click();
        return this;
    }

    @Step("Сфера деятельности - Рестораны ")
    public DBP_3_SphereActivities Restaurants() {
        Restaurants.click();
        return this;
    }
    
}
