package tests.web;

import annotations.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.DBProject.CreateProdject.*;
import pages.DBProject.CreateProdject.DBP_4_specialization.specialization_Servise;
import pages.DBProject.DBP_main;

import static io.qameta.allure.SeverityLevel.BLOCKER;


@Owner("Никулин Дмитрий")
@Feature("Создание проекта")

public class CreateProdject extends TestBase {

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
        MP
                .Open()
                .STARTcreate();

        DBP_1_add_prodject ADDProject = new DBP_1_add_prodject();
        ADDProject
                .CreateNewProdject();

        DBP_2_TypeProject  TypeProject = new DBP_2_TypeProject();
        TypeProject.CreateCompany();

        DBP_3_SphereActivities Sphere = new DBP_3_SphereActivities();
        Sphere.Servise();

        specialization_Servise Servise = new specialization_Servise();
        Servise.Cleaning();
        MP.Continues();

        DBP_5_AboutYourBusiness AYB = new DBP_5_AboutYourBusiness();
        AYB
                .Odin_filial()
                .ot_2_do_5()
                .first_experience()
                .reklama_v_internete();
        MP.Continues();

        DBP_6_MainINFO INFO = new DBP_6_MainINFO();
        INFO
                .FIO("a")
                .House("sa")
                .Street("sa")
                .Indecs("as")
                .Phones("652")
                .Consent_checkbox()
                .Create_company();

    }


    }
