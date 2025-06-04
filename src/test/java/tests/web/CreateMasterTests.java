package tests.web;

import annotations.WithLogin;
import config.TestsConfig;
import data.MasterData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MastersPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Разживин Даниил")
@Feature("Сотрудники")
public class CreateMasterTests extends TestBase {

    final MastersPage mastersPage = new MastersPage();
    TestsConfig config = ConfigFactory.create(TestsConfig.class);


    @WithLogin
    @Test
    @Severity(BLOCKER)
    @Tags({
            @Tag("web"),
            @Tag("master")
    })
    @DisplayName("Создание сотрудника")
    void successfulCreateMasterTest() {
        MasterData masterData = MasterData.fakeMasterData();
        mastersPage.OpenMastersPage(config.getCompanyUrl())
            .ClickAddMaster()
            .InputValueMaster(
                    masterData.getMasterName(),
                    masterData.getMasterSurname(),
                    masterData.getMasterPost())
            .ClickSaveMaster()
                .FillProfileMaster(
                        masterData.getMasterPhoneNumber(),
                        masterData.getMasterEmail(),
                        masterData.getMasterInfo());
    }
}
