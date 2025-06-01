package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Servise {

    private final SelenideElement Servise = $x("//div[@data-name='services']"),
            Photostudio = $x("//label[@for='services-52']"),
            Cleaning = $x("//label[@for='services-55']"),
            ServicesMassage = $x("//label[@for='services-19']"),
            Other = $x("//label[@for='services-27']"),
            Coworking = $x("//label[@for='services-54']"),
            Psychology = $x("//label[@for='services-56']");

}
