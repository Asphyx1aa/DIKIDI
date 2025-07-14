package pages.DO;

import com.codeborne.selenide.SelenideElement;
import data.MasterData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MastersPage {
    final SelenideElement
            masterCreateModal = $(".master-create"),
            addMasterButton = $(".company-masters .btn-primary"),
            masterNameInput = $(".master-create input[name='name']"),
            masterSurnameInput = $(".master-create input[name='surname']"),
            masterJobTitleInput = $(".master-create input[name='post']"),
            masterCategoryDropdown = $(".master-create .bootstrap-select"),
            masterCategoryItem = $(".master-create .dropdown-menu").$("a[tabindex='0']"),
            saveMasterButton = $(".master-create button[type='submit']");

    @Step("Открываем профиль компании")
    public MastersPage openMastersPage(String companyId) {
        open("/owner/masters/?company=" + companyId);
        return this;
    }

    @Step("Кликаем на кнопку Добавить сотрудника")
    public MastersPage clickAddMaster() {
        addMasterButton.shouldBe(visible).click();
        return this;
    }

    @Step("Заполняем форму добавления сотрудника")
    public MastersPage fillMasterForm(String masterName, String masterSurname, String masterJobTitle) {
        masterCreateModal.shouldBe(visible);
        masterNameInput.setValue(masterName);
        masterSurnameInput.setValue(masterSurname);
        masterJobTitleInput.setValue(masterJobTitle);
        masterCategoryDropdown.click();
        masterCategoryItem.click();
        return this;
    }

    @Step("Сохраняем информацию о сотруднике")
    public MastersPage clickSaveMaster() {
        saveMasterButton.shouldBe(visible).click();
        return this;
    }
}
