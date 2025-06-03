package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MastersPage {
    final SelenideElement
            addMasterButton = $("company-masters content").$("btn btn-primary"),
            nameMasterInput = $("modal-content").$("[name='name']"),
            surnameMasterInput = $("modal-content").$("[name='surname']"),
            postMasterInput = $("modal-content").$("[name='post']"),
            categoryMasterDropdownButton = $("modal-content").$("[name='category']"),
            CategoryMasterDropdownMenu = $("dropdown-menu open"),
            addInfoMasterButton = $("modal-content").$("[name='post']");

    @Step("Открываем профиль компании")
    public MastersPage OpenMastersPage(String companyId) {
        open("/ru/masters/" + companyId);
        return this;
    }

    @Step("Кликаем на кнопку Добавить сотрудника, открытие модального окна")
    public MastersPage ClickAddMaster(){
        addMasterButton.shouldBe(visible).click();
        return this;
    }

    @Step("Кликаем на кнопку Добавить сотрудника, открытие модального окна")
    public MastersPage InputValueMaster(){
        nameMasterInput.setValue("");
        surnameMasterInput.setValue("");
        postMasterInput.setValue("");
        categoryMasterDropdownButton.click();
        CategoryMasterDropdownMenu.shouldHave(text("Администратор"));
        return this;
    }

    @Step("Сохраняем информацию о сотруднике")
    public MastersPage ClickSaveMaster(){
        addInfoMasterButton.shouldBe(visible).click();
        return this;
    }
}
