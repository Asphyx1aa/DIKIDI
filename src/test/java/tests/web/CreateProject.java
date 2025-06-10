package tests.web;

import annotations.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CompanyPage;
import pages.DBProject.CreateProdject.*;
import pages.DBProject.CreateProdject.DBP_4_specialization.specialization_Servise;
import pages.DBProject.DBP_main;

import static io.qameta.allure.SeverityLevel.BLOCKER;


@Owner("Никулин Дмитрий")
@Feature("Создание проекта")

public class CreateProject extends TestBase {

    DBP_1_add_prodject ADDProject = new DBP_1_add_prodject();

    @WithLogin //Быстрый вход в акк
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("master")
    })
    @DisplayName("Создание проекта")
    void createProdject() {

        DBP_main MP = new DBP_main();
        DBP_1_add_prodject ADDProject = new DBP_1_add_prodject();
        DBP_2_TypeProject TypeProject = new DBP_2_TypeProject();
        DBP_3_SphereActivities Sphere = new DBP_3_SphereActivities();
        specialization_Servise Servise = new specialization_Servise();
        DBP_5_AboutYourBusiness AYB = new DBP_5_AboutYourBusiness();
        DBP_6_MainINFO INFO = new DBP_6_MainINFO();
        CompanyPage Company = new CompanyPage();

        MP
                .Open()
                .STARTcreate();
        ADDProject
                .CreateNewProdject();
        TypeProject
                .CreateCompany();
        Sphere
                .Servise();
        Servise
                .Cleaning();
        MP
                .Continues();
        AYB
                .Odin_filial()
                .ot_2_do_5()
                .first_experience()
                .reklama_v_internete();
        MP.
                Continues();
        INFO
                .FIO("Название")
                .COUNTRY(57)
//                .City("Москва")
                .Street("Машиностроителей")
                .House("10")
                .Indecs("155055")
                .Code_Phones(49)
                .Consent_checkbox()
                .Phones("9965906602")
                .Create_company();
        Company.
                checkURL();

    }


}
