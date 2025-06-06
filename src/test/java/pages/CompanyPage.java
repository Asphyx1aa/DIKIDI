package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.DBProject.CreateProdject.DBP_6_MainINFO;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record='/ru/record/3554']"),
            iframeForAppointment = $("iframe[src*='/ru/record/3554']"),
            mastersButtonIframe = $(".nr-option.masters"),
            master = $(".nr-item.sm-master"),
            continueButtonMaster = $(".nr-step.sm").$(".nr-continue"),
            continueButtonService = $(".nr-step.ssm").$(".nr-continue"),
            finishButton = $(".nr-step.cf").$(".nr-continue"),
            reservationButton = $(".hour-list").$(".nr-time"),
            secondTimeOption = $$(".time-list").first(),
            checkbox = $(".nr-step.ai").$("label[for='agreement2-2']"),
            finishButtonSecond = $(".nr-step.ai").$(".nr-continue.nr-shimmer"),
            service = $(".btn-selected"),
            CheckCreateCompany = $x("//h1[text()='Профиль']");

    @Step("Открываем профиль компании")
    public CompanyPage openCompanyPage(String companyId) {
        open("/ru/profile/" + companyId);
        return this;
    }

    @Step("Кликаем на кнопку Записаться")
    public CompanyPage clickOnCreateAppointmentButton() {
        makeAppointmentButton.click();
        return this;
    }

    @Step("Переходим в iframe")
    public CompanyPage switchToIframe() {
        switchTo().frame(iframeForAppointment);
        return this;
    }

    @Step("Выбираем способ записи через Сотрудника")
    public CompanyPage makeAppointmentToMaster() {
        mastersButtonIframe.should(appear).click();
        return this;
    }

    @Step("Выбираем сотрудника и переходим на следующий шаг")
    public CompanyPage chooseMaster() {
        master.shouldBe(visible).click();
        continueButtonMaster.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем услугу и переходим на следующий шаг")
    public CompanyPage chooseService() {
        service.shouldBe(visible).click();
        continueButtonService.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Выбираем время для записи")
    public CompanyPage chooseTimeForAppointment() {
        reservationButton.should(exist).shouldBe(visible);
        reservationButton.hover().click();

        if (secondTimeOption.exists()) {
            secondTimeOption.shouldBe(visible).click();
        }

        return this;
    }

    @Step("Нажимаем на кнопку Продолжить на шаге 'Контактная информация'")
    public CompanyPage clickOnContinueButton() {
        sleep(3000);
        finishButton.shouldBe(visible).should(exist).hover().click();
        return this;
    }

    @Step("Нажимаем на чекбокс'")
    public CompanyPage completeAppointment() {
        if(checkbox.exists()) {
            checkbox.shouldBe(visible).click();
        }
        finishButtonSecond.shouldBe(visible).hover().click();
        return this;
    }

    @Step("Проверка url Профиля компании")
    public CompanyPage CheckURL () {
        CheckCreateCompany.shouldBe(visible);
        return this;
    }
}
