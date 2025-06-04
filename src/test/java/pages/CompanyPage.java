package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.DBProject.CreateProdject.DBP_6_MainINFO;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyPage {

    final SelenideElement makeAppointmentButton = $(".booking").$("a[data-record='/ru/record/1684']"),
            iframeForAppointment = $("iframe[style='opacity: 1;']"),
            mastersButtonIframe = $(".nr-option.masters"),
            master = $(".nr-item.sm-master"),
            continueButton = $(".nr-step.sm").$(".nr-continue"),
            continueButton2 = $(".nr-step.ssm").$(".nr-continue.nr-animated").$("a.btn"),
            reservationButton = $(".nr-step.sdt").$$(".hour-list").first().$(".nr-time"),
            finishButton = $(".nr-step.cf").$(".nr-next").$("span"),
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
    public CompanyPage SwitchToIframe() {
        switchTo().frame(iframeForAppointment);
        mastersButtonIframe.click();
        master.shouldBe(visible).click();
        continueButton.shouldBe(visible).click();
        service.shouldBe(visible).click();
        continueButton2.click();
        reservationButton.click();
        finishButton.click();
        checkbox.click();
        finishButtonSecond.click();
        return this;
    }

    @Step("Проверка url Профиля компании")
    public  CompanyPage CheckURL () {
        CheckCreateCompany.shouldBe(visible);
        return this;
    }





}
