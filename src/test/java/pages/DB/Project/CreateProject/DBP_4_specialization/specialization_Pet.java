package pages.DB.Project.CreateProject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Pet {
    private final SelenideElement

            Pet = $x("//div[@data-name='pets']"),
            Grooming = $x("label[@for='pets-42']"),
            Veterinary = $x("label[@for='pets-41']");

    public specialization_Pet Pet() {
        Pet.click();
        return this;
    }

    public specialization_Pet Grooming() {
        Grooming.click();
        return this;
    }

    public specialization_Pet Veterinary() {
        Veterinary.click();
        return this;
    }

}
