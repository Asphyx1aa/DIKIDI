package ru.dikidi.business.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.dikidi.common.annotations.WithLogin;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.common.config.TestsConfig;
import ru.dikidi.common.data.MasterData;
import ru.dikidi.online.pages.MastersPage;

import java.util.Locale;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Разживин Даниил")
@Feature("Сотрудники")
public class MasterTests extends WebTestBase {

    final MastersPage mastersPage = new MastersPage();
    final static TestsConfig config = ConfigFactory.create(TestsConfig.class);

    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("master")
    })
    @DisplayName("Проверка успешного создания сотрудника")
    void successfulCreateMasterTest() {
        Locale locale = new Locale("ru");
        MasterData masterData = MasterData.fakeMasterData();
        String companyId = config.getCompanyId();

        mastersPage.openMastersPage(companyId)
                .clickAddMaster()
                .fillMasterForm(masterData.getMasterName(), masterData.getMasterSurname(), masterData.getMasterPost())
                .clickSaveMaster();
    }
}
