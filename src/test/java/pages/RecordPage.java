package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RecordPage {
    final SelenideElement cancelAppointmentButton = $("a[data-remove^='/ajax/record/remove']");

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
}
