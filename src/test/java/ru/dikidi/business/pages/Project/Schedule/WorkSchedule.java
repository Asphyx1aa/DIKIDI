package ru.dikidi.business.pages.Project.Schedule;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WorkSchedule {


    private int iterationsTest = 0;
    ElementsCollection workScheduleRow = $$(".sch_y_bar--row");

    SelenideElement
            saveWorkSchedule = $(".sch_time--save"),
            dropDownStartTime = $(".btn-group.bootstrap-select.from-control.sch_time--work_from"),
            selectorStartTime = $(".btn-group.bootstrap-select.from-control.sch_time--work_from.open").$("li[data-original-index='10']"),
            dropDownEndTime = $(".btn-group.bootstrap-select.from-control.sch_time--work_to"),
            selectorEndTime = $(".btn-group.bootstrap-select.from-control.sch_time--work_to.open").$("li[data-original-index='40']"),

            isBreak = $("input[name='lunch']").closest("label"),
            dropDownLunchFrom = $(".btn-group.bootstrap-select.from-control.sch_time--lunch_from"),
            selectorLunchFromTime = $(".sch_time--lunch_from.open").$("li[data-original-index='20']"),
            dropDownLunchTo = $(".btn-group.bootstrap-select.from-control.sch_time--lunch_to"),
            selectorLunchToTime = $(".sch_time--lunch_to.open").$("li[data-original-index='35']");

    @Step
    public WorkSchedule SaveDefaultScheduleForMonthOnceMaster(String companyId) {
        open("https://dikidi.tech/ru/owner/schedule/?company=" + companyId);
        workScheduleRow.get(iterationsTest).shouldBe(visible).click();
        saveWorkSchedule.shouldBe(visible).click();
        iterationsTest++;
        refresh();
        return this;
    }

    @Step
    public WorkSchedule SaveCustomScheduleForMonthOnceMaster() {
        workScheduleRow.get(iterationsTest).shouldBe(visible).click();
        dropDownStartTime.shouldBe(clickable).click();
        selectorStartTime.shouldBe(clickable).click();
        dropDownEndTime.shouldBe(clickable).click();
        selectorEndTime.shouldBe(clickable).click();
        saveWorkSchedule.shouldBe(clickable).click();
        iterationsTest++;
        refresh();
        return this;
    }

    @Step
    public WorkSchedule SaveDefaultScheduleForMonthWithLunchOnceMaster() {
        workScheduleRow.get(iterationsTest).shouldBe(visible).click();
        dropDownStartTime.shouldBe(clickable).click();
        selectorStartTime.shouldBe(clickable).click();
        isBreak.click();
        dropDownLunchFrom.click();
        selectorLunchFromTime.click();
        dropDownLunchTo.click();
        selectorLunchToTime.click();
        saveWorkSchedule.click();
        iterationsTest++;
        refresh();
        return this;
    }
}
