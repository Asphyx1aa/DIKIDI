package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Healing {
    private final SelenideElement
            Healing = $x("//div[@data-name='health']"),
            Dentistry = $x("//label['@for='health-31']"),
            Sauna = $x("//label['@for='health-44']"),
            Medicine = $x("//label['@for='health-30']"),
            Analyzes = $x("//label['@for='health-32']"),
            SPA = $x("//label['@for='health-21']");
}
