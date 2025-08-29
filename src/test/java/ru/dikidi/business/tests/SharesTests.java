package ru.dikidi.business.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dikidi.business.pages.Project.Shares.SharesCreatePage;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.config.TestsConfig;
import ru.dikidi.common.data.ShareData;
import ru.dikidi.online.tests.TestBase;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Разживин Даниил")
@Feature("Создание акции")
public class SharesTests extends TestBase{

    private final SharesCreatePage sharesCreatePage = new SharesCreatePage();
    private final static TestsConfig config = ConfigFactory.create(TestsConfig.class);
    ShareData shareData = ShareData.fakeShareData();

    String companyId = config.getCompanyId();
    String titleShare = shareData.getTitleShare();
    String descriptionShare = shareData.getDescriptionShare();

    @WithLogin
    @Test
    @Severity(NORMAL)
    @Tags({
        @Tag("web"),
        @Tag("share")
    })
    void CreateSimpleShare(){
        sharesCreatePage.openPage(companyId)
            .fillTitleShare(titleShare)
            .fillDescriptionShare(descriptionShare)
            .loadBasicImage()
            .setGeneralPercentDiscountShare("40")
            .selectServicesForShare(1)
            .saveShare();
    }

    @WithLogin
    @Test
    @Severity(NORMAL)
    @Tags({
        @Tag("web"),
        @Tag("share")
    })
    void CreateMomentRecordShare(){
        sharesCreatePage.openPage(companyId)
            .fillTitleShare(titleShare)
            .fillDescriptionShare(descriptionShare)
            .loadBasicImage()
            .setGeneralPercentDiscountShare("32")
            .selectTypePeriodShare("Момент записи")
            .selectServicesForShare(1)
            .saveShare();
    }

    @WithLogin
    @Test
    @Severity(NORMAL)
    @Tags({
        @Tag("web"),
        @Tag("share")
    })
    void CreatePeriodRecordShare(){
        sharesCreatePage.openPage(companyId)
            .fillTitleShare(titleShare)
            .fillDescriptionShare(descriptionShare)
            .loadBasicImage()
            .setGeneralPercentDiscountShare("32")
            .selectTypePeriodShare("Время визита")
            .selectServicesForShare(1)
            .saveShare();
    }

    @WithLogin
    @Test
    @Severity(NORMAL)
    @Tags({
        @Tag("web"),
        @Tag("share")
    })
    void CreateWithIndividualPercentForServices(){
        sharesCreatePage.openPage(companyId)
            .fillTitleShare(titleShare)
            .fillDescriptionShare(descriptionShare)
            .loadBasicImage()
            .selectServicesForShare(4)
            .setPercentForEveryServices("12" ,4)
            .saveShare();
    }

    @WithLogin
    @Test //TODO не написано
    @Severity(NORMAL)
    @Tags({
        @Tag("web"),
        @Tag("share")
    })
    void CreateShareWithCustomMasters(){
        sharesCreatePage.openPage(companyId)
                .fillTitleShare(titleShare)
                .fillDescriptionShare(descriptionShare)
                .loadBasicImage()
                .selectServicesForShare(4)
                .setPercentForEveryServices("12" ,4)
                .saveShare();
    }
}
