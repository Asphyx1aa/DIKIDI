package pages.DBProject.CreateProdject.DBP_4_specialization;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class specialization_Beauty {
    private final SelenideElement
            Usy_boroda = $x("//label[@for='beauty-25']"),
            Depilation_epilation = $x("//label[@for='beauty-11']"),
            Barberchop = $x("//label[@for='beauty-29']"),
            Kosmetologiya_ukhod = $x("//label[@for='beauty-15']"),
            Hairdressing_services = $x("//label[@for='beauty-1']"),
            Permanent_tattoo = $x("//label[@for='beauty-23']"),
            Resnitsy = $x("//label[@for='beauty-9']"),
            Brovi = $x("//label[@for='beauty-13']"),
            Vizazh = $x("//label[@for='beauty-17']"),
            Nogtevoy_servis = $x("//label[@for='beauty-7']"),
            BeautyMassage = $x("//label[@for='beauty-19']");




    public specialization_Beauty Usy_boroda(){
        Usy_boroda.click();
        return this;
    }

    public specialization_Beauty Depilation_epilation(){
        Depilation_epilation.click();
        return this;
    }

    public specialization_Beauty Barberchop(){
        Barberchop.click();
        return this;
    }

    public specialization_Beauty Kosmetologiya_ukhod(){
        Kosmetologiya_ukhod.click();
        return this;
    }

    public specialization_Beauty Hairdressing_services(){
        Hairdressing_services.click();
        return this;
    }

    public specialization_Beauty Permanent_tattoo(){
        Permanent_tattoo.click();
        return this;
    }

    public specialization_Beauty Resnitsy(){
        Resnitsy.click();
        return this;
    }

    public specialization_Beauty Brovi(){
        Brovi.click();
        return this;
    }

    public specialization_Beauty Vizazh(){
        Vizazh.click();
        return this;
    }

    public specialization_Beauty Nogtevoy_servis(){
        Nogtevoy_servis.click();
        return this;
    }

    public specialization_Beauty Massage(){
        BeautyMassage.click();
        return this;
    }

}
