package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Game {
    private final SelenideElement


            Game = $x("//div[@data-name='recreation']"),
            Bouling = $x("label[@for='recreation-47']"),
            Kibersport = $x("label[@for='recreation-46']"),
            Quest = $x("label[@for='recreation-43']");


    public Game Game(){
        Game.click();
        return this;
    }

    public Game Bouling(){
        Bouling.click();
        return this;
    }

    public Game Kibersport(){
        Kibersport.click();
        return this;
    }

    public Game Quest(){
        Quest.click();
        return this;
    }
}
