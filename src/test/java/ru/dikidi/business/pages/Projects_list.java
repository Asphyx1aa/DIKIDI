package ru.dikidi.business.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Projects_list {


    String FULLURL = "https://dikidi.tech/ru/business/projects";
    private final SelenideElement CreateNew = $x("//button[@class='new-elements-button blue create-promotions']"),

    BACK = $x("//button[@class='action-btn new-elements-button-outline blue back']"),
            Continue = $x("//button[@class='action-btn new-elements-button blue next']");

    @Step("Начала создания проекта - Добавить новый")
    public Projects_list STARTcreate() {
        CreateNew.click();
        return this;
    }

    @Step("Открытие страницы business/project")
    public Projects_list Open() {
        open(FULLURL);
        return this;
    }

    @Step("Продолжить в форме создания")
    public Projects_list Continues() {
        Continue.click();
        return this;
    }

    @Step("Открытие проекта")
    private  SelenideElement OpenProject(int id_project) {
        return $x(String.format("//div[@data-id=%d]", id_project)).shouldBe(visible, Duration.ofSeconds(10));
    }

}
