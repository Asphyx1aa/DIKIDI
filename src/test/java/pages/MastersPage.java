package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import data.MasterData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MastersPage {
    final SelenideElement //TODO Надо изменить пути
            addMasterButton = $x("//button[text()='Добавить сотрудника']"),
            nameMasterInput = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div:nth-child(2) > div > input"),
            surnameMasterInput = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div:nth-child(3) > div > input"),
            postMasterInput = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div:nth-child(4) > div > input"),
            categoryMasterDropdownButton = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div:nth-child(5) > div > button"),
            categoryMasterDropdownMenu = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div:nth-child(5) > div > div > ul > li:nth-child(2) > a"),
            addInfoMasterButton = $("body > div.bootbox.modal.fade.sw-dialog.master-create.in > div > div > div > div > form > div.form-group.sw.btns > button"),

    numberPhoneMasterInput = $("#master-profile-21370-8144 > div.modal-sub-body.indent > div > div.content-fields.clearfix > div > div:nth-child(3) > div:nth-child(1) > div > div > table > tbody > tr > td:nth-child(3) > input[type=text]:nth-child(1)"),
            emailMasterInput = $("#master-profile-21370-8144 > div.modal-sub-body.indent > div > div.content-fields.clearfix > div > div:nth-child(3) > div:nth-child(2) > div > div > input"),
            infoMasterInput = $("#master-profile-21370-8144 > div.modal-sub-body.indent > div > div.content-fields.clearfix > div > div:nth-child(4) > div > div > textarea"),
            saveProfileMaster = $("#master-profile-21370-8144 > div.footer > div > div.cols.text-right > button");

    MasterData masterData = MasterData.fakeMasterData();

    @Step("Открываем профиль компании")
    public MastersPage openMastersPage(String companyId) {
        open("/ru/owner/masters/?company=" + companyId);
        return this;
    }

    @Step("Кликаем на кнопку Добавить сотрудника, открытие модального окна")
    public MastersPage clickAddMaster() {
        addMasterButton.shouldBe(visible).click();
        return this;
    }

    @Step("Кликаем на кнопку Добавить сотрудника, открытие модального окна")
    public MastersPage inputValueMaster(
            String nameMaster,
            String surnameMaster,
            String postMaster) {
        nameMasterInput.setValue(nameMaster);
        surnameMasterInput.setValue(surnameMaster);
        postMasterInput.setValue(postMaster);
        categoryMasterDropdownButton.click();
        categoryMasterDropdownMenu.click();
        return this;
    }

    @Step("Сохраняем информацию о сотруднике")
    public MastersPage clickSaveMaster() {
        addInfoMasterButton.shouldBe(visible).click();
        return this;
    }

    @Step("Добавление информации сотруднику")
    public MastersPage fillProfileMaster(String phone, String email, String info) {
        numberPhoneMasterInput.setValue(phone);
        emailMasterInput.setValue(email);
        infoMasterInput.setValue(info);
        saveProfileMaster.click();
        return this;
    }
}
