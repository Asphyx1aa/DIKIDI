package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Restaurants {
    private final SelenideElement
            Restaurants_Restaurants = $x("label[@for='food-45']");

    public Restaurants Restaurant() {
        Restaurants_Restaurants.click();
        return this;
    }

}
