package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Healing {
    private final SelenideElement
            Healing = $x("//div[@data-name='health']"),
            Dentistry = $x("//label['@for='health-31']"),
            Sauna = $x("//label['@for='health-44']"),
            Medicine = $x("//label['@for='health-30']"),
            Analyzes = $x("//label['@for='health-32']"),
            SPA = $x("//label['@for='health-21']");

    public specialization_Healing Healing() {
        Healing.click();
        return this;
    }

    public specialization_Healing Dentistry() {
        Dentistry.click();
        return this;
    }

    public specialization_Healing Sauna() {
        Sauna.click();
        return this;
    }

    public specialization_Healing Medicine() {
        Medicine.click();
        return this;
    }

    public specialization_Healing Analyzes() {
        Analyzes.click();
        return this;
    }

    public specialization_Healing SPA() {
        SPA.click();
        return this;
    }

}
