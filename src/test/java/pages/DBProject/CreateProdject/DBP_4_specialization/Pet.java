package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Pet {
    private final SelenideElement

            Pet = $x("//div[@data-name='pets']"),
            Grooming = $x("label[@for='pets-42']"),
            Veterinary = $x("label[@for='pets-41']");

    public  Pet Pet(){
        Pet.click();
        return this;
    }

    public  Pet Grooming(){
        Grooming.click();
        return this;
    }

    public  Pet Veterinary(){
        Veterinary.click();
        return this;
    }

}
