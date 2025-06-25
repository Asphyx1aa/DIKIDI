package pages.DB.Project.CreateProject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Education {
    private final SelenideElement

            Education = $x("//div[@data-name='education']"),
            Repetitor = $x("label[@for='recreation-49']"),
            Language_school = $x("label[@for='recreation-51']"),
            Driving_school = $x("label[@for='recreation-48']"),
            Kursy = $x("label[@for='education-50']");

    public specialization_Education Education() {
        Education.click();
        return this;
    }

    public specialization_Education Repetitor() {
        Repetitor.click();
        return this;
    }

    public specialization_Education Language_school() {
        Language_school.click();
        return this;
    }

    public specialization_Education Driving_school() {
        Driving_school.click();
        return this;
    }

    public specialization_Education Kursy() {
        Kursy.click();
        return this;
    }


}
