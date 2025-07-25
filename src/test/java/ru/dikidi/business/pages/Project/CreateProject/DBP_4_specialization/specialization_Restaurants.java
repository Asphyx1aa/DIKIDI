package ru.dikidi.business.pages.Project.CreateProject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Restaurants {
    private final SelenideElement
            Restaurants_Restaurants = $x("label[@for='food-45']");

    public specialization_Restaurants Restaurant() {
        Restaurants_Restaurants.click();
        return this;
    }

}
