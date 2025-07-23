package tests.web;

import annotations.WithLogin;
import config.TestsConfig;
import helpers.helpers;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DO.CompanyPage;
import pages.DB.Project.CreateProject.*;
import pages.DB.Project.CreateProject.DBP_4_specialization.specialization_Servise;
import pages.DB.Projects_list;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.BLOCKER;


@Owner("Никулин Дмитрий")
@Feature("Создание проекта")

public class CreateProject extends TestBase {


    //Переменные для быстрого создания теста
    String NameProject = "Autotest";
    Integer CountryNumber = 57; // мб переделать на ru en но пока хз
    String CityName = "Москва";
    String StreetName = "Машиностроителей";
    String HouseName = "10";
    String IndecsMail = "155055";
    Integer Country_Code_Phones = 49; // Надо бы где-то таблицу со всем этим добром хранить чтоб быстро доставать
    String Phone_numder = "9965906602";


    @WithLogin //Быстрый вход в акк
    @Test // Обозначает тест
    @Order(1) //Указание порядка теста Авторизация->Создание->Настройка->Удаление чистый тест
    @Severity(BLOCKER) // Алюр степень важности
    @Tags({ //Теги
            @Tag("web"),
            @Tag("project")
    })
    @DisplayName("Создание проекта") // Название проекта
    void createProdject() {
            //Обозначение Page
            Projects_list MP = new Projects_list();
            DBP_1_add_prodject ADDProject = new DBP_1_add_prodject();
            DBP_2_TypeProject TypeProject = new DBP_2_TypeProject();
            DBP_3_SphereActivities Sphere = new DBP_3_SphereActivities();
            specialization_Servise Servise = new specialization_Servise();
            DBP_5_AboutYourBusiness AYB = new DBP_5_AboutYourBusiness();
            DBP_6_MainINFO INFO = new DBP_6_MainINFO();
            CompanyPage Company = new CompanyPage();
            DeleteProject Delete = new DeleteProject();
            TestBase Base = new TestBase();
            helpers HELP = new helpers();
        // Тест
            MP
                    .Open()
                    .STARTcreate();

            ADDProject.CreateNewProdject();
            TypeProject.CreateCompany();
            Sphere.Servise();
            Servise.Cleaning();
            MP.Continues();

            AYB
                    .Odin_filial()
                    .ot_2_do_5()
                    .first_experience()
                    .reklama_v_internete();

            MP.Continues();

            INFO
                    .FIO(NameProject)
                    .COUNTRY(CountryNumber)
    //                .City(CityName)
                    .Street(StreetName)
                    .House(HouseName)
                    .Indecs(IndecsMail)
                    .Code_Phones(Country_Code_Phones)
                    .Consent_checkbox()
                    .Consent_mailing_checkbox()
                    .Phones(Phone_numder)
                    .Create_company();

            Company.checkURL(); // Проверка

            //Удаление проекта
    //        MP.Open();
    //        Delete.Last();


    }



}
