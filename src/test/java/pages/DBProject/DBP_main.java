package pages.DBProject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DBP_main {


    String FULLURL = "https://test.dikidi.ru/ru/business/projects";
    private final SelenideElement CreateNew = $x("//button[@class='new-elements-button blue create-promotions']"),

    BACK = $x("//button[@class='action-btn new-elements-button-outline blue back']"),
            Continue = $x("//button[@class='action-btn new-elements-button blue next']");

    @Step("Начала создания проекта - Добавить новый")
    public DBP_main STARTcreate() {
        CreateNew.click();
        return this;
    }

    @Step("Открытие страницы business/project")
    public DBP_main Open() {
        open(FULLURL);
        return this;
    }

    @Step("Продолжить в форме создания")
    public DBP_main Continues() {
        Continue.click();
        return this;
    }

}
