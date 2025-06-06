package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BookingWidgetPage {

    final SelenideElement mastersButtonIframe = $(".nr-option.masters"),
            master = $(".nr-item.sm-master"),
            continueButtonMaster = $(".nr-step.sm").$(".nr-continue"),
            continueButtonService = $(".nr-step.ssm").$(".nr-continue"),
            finishButton = $(".nr-step.cf").$(".nr-continue"),
            reservationButton = $(".hour-list").$(".nr-time"),
            secondTimeOption = $$(".time-list").first(),
            checkbox = $(".nr-step.ai").$("label[for='agreement2-2']"),
            finishButtonSecond = $(".nr-step.ai").$(".nr-continue.nr-shimmer"),
            service = $(".btn-selected");

    @Step("Выбираем способ записи через Сотрудника")
    public BookingWidgetPage makeAppointmentToMaster() {
        mastersButtonIframe.should(appear).click();
        return this;
    }

    @Step("Выбираем сотрудника и переходим на следующий шаг")
    public BookingWidgetPage chooseMaster() {
        master.shouldBe(visible).click();
        continueButtonMaster.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем услугу и переходим на следующий шаг")
    public BookingWidgetPage chooseService() {
        service.shouldBe(visible).click();
        continueButtonService.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем время для записи")
    public BookingWidgetPage chooseTimeForAppointment() {
        reservationButton.should(exist).shouldBe(visible);
        reservationButton.hover().click();

        if (secondTimeOption.exists()) {
            secondTimeOption.shouldBe(visible).click();
        }

        return this;
    }

    @Step("Нажимаем на кнопку Продолжить на шаге 'Контактная информация'")
    public BookingWidgetPage clickOnContinueButton() {
        sleep(3000);
        finishButton.shouldBe(visible).should(exist).hover().click();
        return this;
    }

    @Step("Подтверждаем запись'")
    public BookingWidgetPage completeAppointment() {
        if (checkbox.exists()) {
            checkbox.shouldBe(visible).click();
        }
        finishButtonSecond.shouldBe(visible).hover().click();
        return this;
    }
}
