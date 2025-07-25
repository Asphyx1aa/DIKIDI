package ru.dikidi.business.pages.Project.Clients;

import com.codeborne.selenide.SelenideElement;
import ru.dikidi.common.helpers.helpers;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class List_of_Сlients {

    String pagesListClient = "owner/clients/";

    SelenideElement

            ButtonADD_NEW_Client = $x("//button[@class='btn btn-primary insert-btn']"),
            Input_NAME = $x("//input[@name=\"name\"]"),
            Input_NumberPHONE = $("/html/body/div[4]/div/div/div/div/form/div[2]/div[1]/div/input"),
            Button_ADD = $x("//div[@class='form-group sw btns']//button"),
            Check_ADD_client = $x("//div[@class='line-name']//a[text()='123 7999']"),
            Open_dropdown_menu_language = $x("/html/body/div[9]/div/div/div/div/form/div[2]/div[1]/div/div/button");




    private SelenideElement Phonecountrycodename(int code_country) {
        return $x(String.format("//li[@data-code='%d']", code_country)).shouldBe(visible, Duration.ofSeconds(10));
    }

    private  SelenideElement Check_ADD_Client(String Name) {
        return $x("//div[@class='line-name']//a[text()= '"+ Name +"' ]");
    }

    public List_of_Сlients open(){
        helpers.BuilderURL(pagesListClient);
        return this;
    }

    public List_of_Сlients CREATE_NEW_CLIENT(){
        ButtonADD_NEW_Client.click();
        return this;
    }

    public List_of_Сlients Input_Name_NEW_CLIENT(String Name){
        Input_NAME.setValue(Name);
        return this;
    }

    public List_of_Сlients CHANGE_COUNTRY_CODE_NEW_CLIENT(int code_country) {
        Open_dropdown_menu_language.click();
        Phonecountrycodename(code_country).click();
        return this;
    }

    public List_of_Сlients Input_NUMBER_NEW_CLIENT(String Number){
        Input_NumberPHONE.setValue(Number);
        return this;
    }

    public List_of_Сlients Save_NEW_CLIENT(){
        Button_ADD.click();
        return this;
    }

    public List_of_Сlients Check_Create_client(String Name){
        Check_ADD_Client(Name).isDisplayed();
        return this;
    }


}
