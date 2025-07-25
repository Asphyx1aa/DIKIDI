package ru.dikidi.business.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import ru.dikidi.business.pages.Projects_list;
import ru.dikidi.common.annotations.WithLogin;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.SeverityLevel.BLOCKER;

public class DeleteProject {

    //Требуеться оформить по Page Object
    // 2 Варинта использывания
    // ALL = удалить все проекты на акк
    // Last = удалить последний созданный проект
    String MotiveDelete = "ПРОГОН АВТОТЕСТА"; // Текст при удалении



    SelenideElement Not_needed = $x("//label[@for='reason-1']"),
    More = $x("//button[@class='new-elements-button white show-more-button']"),
    Hard_Settings  = $x("//label[@for='reason-2']"),
    necessary_functionality = $x("//label[@for='reason-3']"),
    other_software = $x("//label[@for='reason-4']"),
    Closed = $x("//label[@for='reason-5']"),
    Another_reason = $x("//label[@for='reason-16']"),
    new_reason = $x("//label[@for='reason-18']"),
    first_reason = $x("//label[@for='reason-20']"),
    Another = $x("//label[@for='reason-21']"),
    PoleVvoda = $x("//textarea[@name='description']"),
    DeleteButton = $x("//button[@class='new-elements-button red delete-btn']"),
    FinalButtonDelete = $x("//button[@class='new-elements-button blue success-delete']");
    private SelenideElement Button_Drop(int NumberProject) {
        return $x("//a[@data-href='/ru/business/ajax/projects/modal_delete/?'"+ NumberProject +"'']");
    }


    ElementsCollection ProjectCollection_Button_Ops = $$x("//div[@class='last-column dots']//div[@class = 'new-elements-dots new-elements-expand-clicked']"),
            Collection_ButtonDrop = $$x("//a[@class = 'item remove']");




    //Использовать в 30 тест с созданием проекта
    @WithLogin //Быстрый вход в акк
    @Test // Обозначает тест
    @Order(1) //Указание порядка теста Авторизация->Создание->Настройка->Удаление чистый тест
    @Severity(BLOCKER) // Алюр степень важности
    @Tags({ //Теги
            @Tag("web"),
            @Tag("project")
    })
    @DisplayName("Создание проекта") // Название проекта
    public void ALL() {
        Projects_list MP = new Projects_list();
        MP.Open();
        int count = 30; //Проблема в кнопке показать ещё поэтому пока используем как очистка при переполнении
        for (int i = 0; i < count; i++) {
            Last();
        }
    }

    @WithLogin //Быстрый вход в акк
    @Test // Обозначает тест
    @Order(1) //Указание порядка теста Авторизация->Создание->Настройка->Удаление чистый тест
    @Severity(BLOCKER) // Алюр степень важности
    @Tags({ //Теги
            @Tag("web"),
            @Tag("project"),
            @Tag("delete")
    })
    @DisplayName("Удалить проект") // Название проекта
    public void Last(){
        Projects_list MP = new Projects_list();
        MP.Open();
        ProjectCollection_Button_Ops.first().click();
        Collection_ButtonDrop.first().click();
        DeleteSetting();

    }

    public DeleteProject DeleteSetting(){

        //Чек-бокс причин удаления
        Not_needed.shouldBe(visible).click();
        Hard_Settings.click();
        necessary_functionality.click();
        other_software.click();
        Closed.click();
        Another_reason.click();
        new_reason.click();
        first_reason.click();
        Another.click();

//      Поле ввода текста при удалении
        PoleVvoda.setValue(MotiveDelete);

        //Принятие удаления
        DeleteButton.click();
        FinalButtonDelete.click();
        return this;
    }





}
