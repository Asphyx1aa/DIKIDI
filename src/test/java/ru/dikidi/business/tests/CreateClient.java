package ru.dikidi.business.tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import ru.dikidi.business.pages.Project.Clients.List_of_Сlients;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Никулин Дмитрий")
@Feature("Создание клиента")



public class CreateClient extends TestBase {

    String name_client = "Дмитрий";
    Integer code_country = 49;
    String numder_phone = "79965906602";

    @Order(1) //Указание порядка теста Авторизация->Создание->Настройка->Удаление чистый тест
    @Severity(BLOCKER) // Алюр степень важности
    @Tags({ //Теги
            @Tag("web"),
            @Tag("project")
    })
    @DisplayName("Создание клиента ") // Название проекта
    void Create_Client_ONE() {
        List_of_Сlients Client = new List_of_Сlients();


        Client
                .Open()
                .CREATE_NEW_CLIENT()
                .Input_Name_NEW_CLIENT(name_client)
//                .CHANGE_COUNTRY_CODE_NEW_CLIENT(code_country) //Баг тут
                .Input_NUMBER_NEW_CLIENT(numder_phone)
                .Save_NEW_CLIENT()
                .Check_Create_client(name_client);

    }

}
