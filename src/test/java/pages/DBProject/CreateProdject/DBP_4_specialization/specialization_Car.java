package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Car {
    private final SelenideElement


            Avtoservis = $x("label[@for='auto-38']"),
            Tekhosmotr = $x("label[@for='auto-40']"),
            Shinomontazh = $x("label[@for='auto-37']"),
            Avtomoyka = $x("label[@for='auto-39']");

    public specialization_Car Avtoservis(){
        Avtoservis.click();
        return this;
    }
    public specialization_Car Tekhosmotr(){
        Tekhosmotr.click();
        return this;
    }
    public specialization_Car Shinomontazh(){
        Shinomontazh.click();
        return this;
    }
    public specialization_Car Avtomoyka(){
        Avtomoyka.click();
        return this;
    }
}
