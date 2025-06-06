package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RecordPage {
    final SelenideElement cancelAppointmentButton = $("a[data-remove^='/ajax/record/remove']"),
    confirmCancellationButton = $("button.btn.btn-primary");

    @Step("Открываем страницу 'Мои записи'")
    public RecordPage openPage() {
        open("/ru/recording");
        return this;
    }

    @Step("Нажимаем на кнопку 'Отменить запись'")
    public RecordPage clickOnCancelAppointment() {
        cancelAppointmentButton.click();
        return this;
    }

    @Step("Подтверждаем отмену записи")
    public RecordPage confirmCancellation() {
        confirmCancellationButton.shouldBe(visible).click();
        return this;
    }
}
