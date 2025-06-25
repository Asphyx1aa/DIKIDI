package tests.buildbrand;

import com.codeborne.selenide.Configuration;
import config.BrandConfig;
import config.TestsConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import pages.googlePages.PlayGooglePage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Разживин Даниил")
@Feature("Гугл форма")
public class BuildBrand {

    final PlayGooglePage playGooglePage = new PlayGooglePage();
    final static BrandConfig config = ConfigFactory.create(BrandConfig.class);

    @BeforeAll
    static void dataSetup() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("brand")
    })
    @DisplayName("Заполнение Google Play")
    void FillGooglePlayForm() {

        playGooglePage
            .openPlayGoogle()
            .createApp()
            .fillCreateAppForm()
            .fillPrivacyPolicy()
            .fillAccessApplication()
            .fillAgeRestrictions()
            .fillTargetAudience()
            .fillDataSecurity()
            .fillGovernmentAgencies()
            .fillFinancialFunctions()
            .fillHealth()
            .fillAddIndicator()
            .fillPropertiesForGooglePlay();
    }
}
