package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Game {
    private final SelenideElement


            Game = $x("//div[@data-name='recreation']"),
            Bouling = $x("label[@for='recreation-47']"),
            Kibersport = $x("label[@for='recreation-46']"),
            Quest = $x("label[@for='recreation-43']");


    public specialization_Game Game() {
        Game.click();
        return this;
    }

    public specialization_Game Bouling() {
        Bouling.click();
        return this;
    }

    public specialization_Game Kibersport() {
        Kibersport.click();
        return this;
    }

    public specialization_Game Quest() {
        Quest.click();
        return this;
    }
}
