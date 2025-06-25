package pages.googlePages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PlayGooglePage {

    String appId;
    final SelenideElement
            openFormCreateAppButton = $x("//button[text()='Создать приложение']"),
            titleAppInput = $("ngcontrol=title"),
            selectLanguageDropDown = $(""),
            appOrGameButtonRadioButton = $(""),
            freeOrPaidRadioButton = $(""),
            rulesProgramForDevelopersCheckBox = $(""),
            exportLawsCheckBox = $(""),
            createAppButton = $(""),

    //Политика конфиденциальности
            urlPrivacyPolicyInput = $(""),
            savePrivacyPolicyButton = $(""),
    //Доступ к приложениям
            limitationFunctionsRadioButton = $(""),
            addInstructionButton = $(""),
            titleInstructionInput = $(""),
            usernameAuthInput = $(""),
            passwordAuthInput = $(""),
            noOtherInformationCheckBox = $(""),
            saveInstructionButton = $(""),
            saveLimitationFunctionsButton = $(""),
    //Реклама
            addRadioButton = $(""),
            saveAddButton = $(""),
    //Возрастные ограничения
            fillQuestionnaireButton = $(""),
            emailAgeRestrictionsInput = $(""),
            categoryAppRadioButton = $(""),
            conditionsUseCheckBox = $(""),
            nextAgeRestrictionsButton = $(""),
            downloadAppRadioButton = $(""),
            generalAccessRadioButton = $(""),
            internetContentRadioButton = $(""),
            saleProductRadioButton = $(""),
            otherRadioButton1 = $(""),
            otherRadioButton2 = $(""),
            otherRadioButton3 = $(""),
            otherRadioButton4 = $(""),
            otherRadioButton5 = $(""),
            saveQuestionnaireButton = $(""),
            nextAgeRestrictionsButton2 = $(""),
            saveResumeButton = $(""),
    //Целевая аудитория
            age13_15CheckBox = $(""),
            age16_17CheckBox = $(""),
            age18CheckBox = $(""),
            saveAgeButton = $(""),

    //Безопастность данных
            importPrivacyPolicyButton = $(""),
            loadFilePrivacyPolicyButton = $(""),
            saveFilePrivacyPolicyButton = $(""),
            saveFileModalPrivacyPolicyButton = $(""),
            nextDataSecurityButton = $(""),
            saveDataSecurityButton = $(""),

    //Приложения государственных учреждений
            notStateFunctionRadioButton = $(""),
            saveStateButton = $(""),
    //Финансовые функции
            notFinanceFunctionCheckBox = $(""),
            nextFinanceButton = $(""),
            saveFinanceButton = $(""),

    //Здоровье
            notHealthFunctionCheckBox = $(""),
            saveHealthButton = $(""),
    //Настройки для Google Play
            changeCategoryButton = $(""),
            categoryListDropDown = $(""),
            categoryItem = $(""),
            saveCategoryButton = $(""),
            closeCategoryWindowButton = $(""),

            changeContactButton = $(""),
            emailContactInput = $(""),
            phoneContactInput = $(""),
            websiteContactInput = $(""),
            saveContactButton = $(""),
            closeContactWindowButton = $("");



    @Step("Открываем play.google")
    public PlayGooglePage openPlayGoogle() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app-list");
        return this;
    }

    @Step("Создаём приложение в play.google")
    public PlayGooglePage createApp() {
        openFormCreateAppButton.shouldBe(visible).click();
        return this;
    }

    @Step("Заполняем форму для создания приложения")
    public PlayGooglePage fillCreateAppForm() {
        titleAppInput.setValue("");
        appOrGameButtonRadioButton.shouldBe(visible).click();
        freeOrPaidRadioButton.shouldBe(visible).click();
        rulesProgramForDevelopersCheckBox.shouldBe(visible).click();
        exportLawsCheckBox.shouldBe(visible).click();
        createAppButton.shouldBe(visible).click();

        String currentUrl = WebDriverRunner.url();
        appId = getAppIdFromUrl(currentUrl);
        return this;
    }

    @Step("Заполняем политику конфиденциальности")
    public PlayGooglePage fillPrivacyPolicy() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/privacy-policy?source=dashboard");
        urlPrivacyPolicyInput.shouldBe(visible).setValue("");
        savePrivacyPolicyButton.shouldBe(visible).click();
        return this;
    }

    @Step("Заполняем Доступ к приложениям")
    public PlayGooglePage fillAccessApplication() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/testing-credentials?source=dashboard");
        limitationFunctionsRadioButton.shouldBe(visible).click();
        addInstructionButton.click();
        titleInstructionInput.shouldBe(visible).setValue("//TODO");

        return this;
    }

    @Step("Заполняем Возрастные ограничения")
    public PlayGooglePage fillAgeRestrictions() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/content-rating-overview?source=dashboard");


        return this;
    }

    @Step("Заполняем Целевая аудитория")
    public PlayGooglePage fillTargetAudience() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/target-audience-content?source=dashboard");


        return this;
    }

    @Step("Заполняем Безопасность данных")
    public PlayGooglePage fillDataSecurity() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/data-privacy-security?source=dashboard");


        return this;
    }

    @Step("Заполняем Приложения государственных учреждений")
    public PlayGooglePage fillGovernmentAgencies() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/government-apps?source=dashboard");


        return this;
    }

    @Step("Заполняем Финансовые функции")
    public PlayGooglePage fillFinancialFunctions() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/financial-features?source=dashboard");


        return this;
    }

    @Step("Заполняем Здоровье")
    public PlayGooglePage fillHealth() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/app-content/health?source=dashboard");


        return this;
    }

    @Step("Заполняем Рекламный Индификатор")
    public PlayGooglePage fillAddIndicator() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/" + appId + "/app-content/ad-id-declaration?source=publishing-overview");


        return this;
    }

    @Step("Заполняем Настройки для Google Play")
    public PlayGooglePage fillPropertiesForGooglePlay() {
        open("https://play.google.com/console/u/1/developers/9163113304178487353/app/"+ appId +"/store-settings");


        return this;
    }

    private String getAppIdFromUrl(String url){
        String[] parts = url.split("/");
        return parts[9];
    }
}