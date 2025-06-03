package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Car {
    private final SelenideElement


            Avtoservis = $x("label[@for='auto-38']"),
            Tekhosmotr = $x("label[@for='auto-40']"),
            Shinomontazh = $x("label[@for='auto-37']"),
            Avtomoyka = $x("label[@for='auto-39']");

    public Car Avtoservis(){
        Avtoservis.click();
        return this;
    }
    public Car Tekhosmotr(){
        Tekhosmotr.click();
        return this;
    }
    public Car Shinomontazh(){
        Shinomontazh.click();
        return this;
    }
    public Car Avtomoyka(){
        Avtomoyka.click();
        return this;
    }
}
