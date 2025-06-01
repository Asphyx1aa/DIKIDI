package pages.DBProject.CreateProdject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;

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
}
