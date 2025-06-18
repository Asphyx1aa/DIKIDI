package pages.DB.Project.CreateProject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Sport {
    private final SelenideElement
            Sport = $x("//div[@data-name='sport']"),
            Fitness = $x("//label['@for='sport-33']"),
            Yoga = $x("//label['@for='sport-35']"),
            Yedinoborstva = $x("//label['@for='sport-34']"),
            Dancing = $x("//label['@for='sport-36']");
}
