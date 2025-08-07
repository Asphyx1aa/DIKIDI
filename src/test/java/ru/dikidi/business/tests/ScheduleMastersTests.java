package ru.dikidi.business.tests;

import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.business.tests.api.WorkScheduleTests;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.*;
import ru.dikidi.business.pages.Project.Schedule.WorkSchedule;
import ru.dikidi.common.base.WebTestBase;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static ru.dikidi.common.context.AuthContext.getAuthResponse;

public class ScheduleMastersTests extends WebTestBase {


    WorkSchedule workSchedule = new WorkSchedule();
    WorkScheduleTests workScheduleTests = new WorkScheduleTests();

    @BeforeAll
    public static void CheckConditionTests(){
        open("https://dikidi.tech/ru/owner/schedule/?company=3454");
        ElementsCollection workScheduleRow = $$(".sch_y_bar--row");
        int checkCount = workScheduleRow.size();
        if(checkCount < 3){
            throw new RuntimeException("В графике недостаточно сотрудников для прохождения теста");
        }
    }

    @WithLogin
    @Test
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Заполняем график работы сотрудников через UI")
    void fillScheduleMasters(){
        workSchedule.SaveDefaultScheduleForMonthOnceMaster()
                .SaveCustomScheduleForMonthOnceMaster()
                .SaveDefaultScheduleForMonthWithLunchOnceMaster();
    }

    @WithLogin
    @Test
    @Tags({
            @Tag("web"),
            @Tag("appointment")
    })
    @DisplayName("Заполняем график работы сотрудников через api на месяц вперед, просто костыль, чтобы быстро заполнить" +
            "график для всех сотрудников в проекте")
    void getId(){
        String companyId = config.getCompanyId();
        String token = getAuthResponse().path("data.token");
        workScheduleTests.fillWorkScheduleAllMasters(token, companyId);
    }
}
