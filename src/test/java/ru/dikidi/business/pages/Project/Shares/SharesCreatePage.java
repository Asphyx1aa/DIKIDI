package ru.dikidi.business.pages.Project.Shares;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SharesCreatePage {

    final SelenideElement
    saveShare1 = $(".left .breadcrumbs"),
    saveShare2 = $(".left .breadcrumbs"),
    titleShare = $("#item-name"),
    descriptionShare = $(".panel").$("#description"),
    workDirectionShareDropDown = $(""),
    addAvatarImage = $(""),
    addAvatarImage2 = $(""),
    addImageGallery = $(""),
    generalPercentShare = $(""),
    dateBeginShare = $(""),
    dateEndShare = $(""),
    typePeriodShare = $(""),
    addServicesButton = $(""),
    saveSelectedServiceButton = $(""),

    workerSettingServicesDropDown = $(""),
    removeServicesButton = $("");

    @Step("Открываю страницу")
    public SharesCreatePage openPage(String _companyId){
        open("/owner/masters/?company=" + _companyId);
        return this;
    }

    @Step("Ввод названия акции")
    public SharesCreatePage fillTitleShare(String _titleShare){
        titleShare.shouldBe(visible).setValue(_titleShare);
        return this;
    }

    @Step("Ввод описания акции")
    public SharesCreatePage fillDescriptionShare(String _descriptionShare){
        descriptionShare.shouldBe(visible).setValue(_descriptionShare);
        return this;
    }

    @Step("Установка направления работы акции")
    public SharesCreatePage fillWorkDirectionShare(){
        //TODO
        return this;
    }

    @Step("Загрузка основного изображения галереи")
    public SharesCreatePage loadBasicImage(){
        addAvatarImage.shouldBe(visible).click();
        addAvatarImage2.shouldBe(visible).click();

        return this;
    }

    @Step("Загрузка фото в галерею акции")
    public SharesCreatePage loadGalleryImage(){
        return this;
    }

    @Step("Установка общего процента скидки в акции")
    public SharesCreatePage setGeneralPercentDiscountShare(String _generalPercentDiscount){
        generalPercentShare.shouldBe(visible).setValue(_generalPercentDiscount);
        return this;
    }

    @Step("Установка начального периода акции")
    public SharesCreatePage setDateBeginShare(String _dataBegin){
        dateBeginShare.shouldBe(visible).setValue(_dataBegin);
        return this;
    }

    @Step("Установка конечного периода акции")
    public SharesCreatePage setDateEndShare(String _dataEnd){
        dateEndShare.shouldBe(visible).setValue(_dataEnd);
        return this;
    }

    @Step("Выбор типа периода акции")
    public SharesCreatePage selectTypePeriodShare(String _typeShare){
        $("button[title=" + _typeShare + "]").shouldBe(visible).click();
        return this;
    }

    @Step("Выбор услуг для акции")
    public SharesCreatePage selectServicesForShare(){
        final ElementsCollection listServices = $$("");
        addServicesButton.shouldBe(visible).click();
        listServices.get(1).shouldBe(clickable).click();
        return this;
    }

    @Step("Настройка процентов для каждой услуги")
    public SharesCreatePage setPercentForEveryServices(String _PersonalPercent, int _servicesCount){
        final ElementsCollection individualDiscountServicesInput = $$("");

        for (int i = 0; i < _servicesCount; i++) {
            individualDiscountServicesInput.get(i).setValue(_PersonalPercent);
        }
        return this;
    }

    @Step("Сохранить акцию")
    public SharesCreatePage saveShare(){
        saveShare1.shouldBe(clickable).click();
        return this;
    }
}
