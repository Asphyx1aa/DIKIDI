package ru.dikidi.online.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookingWidgetPage {

    final SelenideElement firstBookingStep = $(".nr-step.po"),
            serviceBookingStep = $(".nr-step.ssm"),
            masterBookingStep = $(".nr-step.sm"),
            contactInformationStep = $(".nr-step.cf"),
            timeReservationStep = $(".nr-step.sdt"),
            completeBookingStep = $(".nr-step.ai"),
            mastersButtonIframe = $(".nr-option.masters"),
            serviceButtonIframe = $(".nr-option.multi"),
            master = $(".nr-item.sm-master"),
            continueButtonMaster = $(".nr-step.sm").$(".nr-continue"),
            continueButtonService = $(".nr-step.ssm").$(".nr-continue"),
            finishButton = $(".nr-step.cf").$(".nr-continue"),
            reservationButton = $(".hour-list").$(".nr-time"),
            secondTimeOption = $$(".time-list").first(),
            checkbox = $(".nr-step.ai").$("label[for='agreement2-2']"),
            finishButtonSecond = $(".nr-step.ai").$(".nr-continue.nr-shimmer"),
            service = $(".btn-selected"),
            successBookingStep = $(".nr-step.final");

    @Step("Выбираем способ записи через Сотрудника")
    public BookingWidgetPage makeAppointmentToMaster() {
        firstBookingStep.shouldBe(visible);
        mastersButtonIframe.shouldBe(visible).click();
        return this;
    }

    @Step("Выбираем способ записи через Услуги")
    public BookingWidgetPage makeAppointmentService() {
        serviceButtonIframe.shouldBe(visible).click();
        return this;
    }

    @Step("Выбираем сотрудника и переходим на следующий шаг")
    public BookingWidgetPage chooseMaster() {
        masterBookingStep.shouldBe(visible);
        master.shouldBe(visible).click();
        continueButtonMaster.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем услугу и переходим на следующий шаг")
    public BookingWidgetPage chooseService() {
        serviceBookingStep.shouldBe(visible);
        service.shouldBe(visible).click();
        continueButtonService.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем время для записи")
    public BookingWidgetPage chooseTimeForAppointment() {
        timeReservationStep.shouldBe(visible);
        reservationButton.should(exist).shouldBe(visible);
        reservationButton.hover().click();

        if (secondTimeOption.exists()) {
            secondTimeOption.shouldBe(visible).click();
        }

        return this;
    }

    @Step("Нажимаем на кнопку Продолжить на шаге 'Контактная информация'")
    public BookingWidgetPage clickOnContinueButton() {
        contactInformationStep.shouldBe(visible);
        finishButton.shouldBe(visible).should(exist).hover().click();
        return this;
    }

    @Step("Подтверждаем запись'")
    public BookingWidgetPage completeAppointment() {
        completeBookingStep.shouldBe(visible);

        if (checkbox.is(visible)) {
            checkbox.click();
        }
        finishButtonSecond.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Проверяем, что запись создалась успешно. Появилось сообщение")
    public BookingWidgetPage checkBookingSuccessMessage() {
        successBookingStep.shouldBe(visible);
        return this;
    }
}
