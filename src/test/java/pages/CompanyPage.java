package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record='/ru/record/1684']"),
            iframeForAppointment = $("iframe[style='opacity: 1;']"),
            mastersButtonIframe = $(".nr-option.masters"),
            master = $(".nr-item.sm-master"),
            continueButton = $x("//a[@class='btn btn-block btn-default btn-stylized nrs-gradient nr-continue' and text()='Продолжить']"),
            continueButton2 = $x("//a[@class='btn btn-default btn-stylized nrs-gradient nr-continue' and text()='Продолжить']"),
            reservationButton = $(".nr-step.sdt").$$(".hour-list").first().$(".nr-time"),
            finishButton = $(".nr-step.cf").$(".nr-next").$("span"),
            checkbox = $(".nr-step.ai").$("label[for='agreement2-2']"),
            finishButtonSecond = $(".nr-step.ai").$(".nr-continue.nr-shimmer"),
            service = $(".btn-selected");

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
    public CompanyPage SwitchToIframe() {
        switchTo().frame(iframeForAppointment);
        mastersButtonIframe.click();
        master.shouldBe(visible).click();
        continueButton2.shouldBe(visible).click();
        service.shouldBe(visible).click();
        continueButton2.click();
        reservationButton.click();
        finishButton.click();
        checkbox.click();
        finishButtonSecond.click();
        return this;
    }

}
