package tests.web;

import annotations.WithLogin;
import data.MasterData;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.DO.MastersPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Owner("Разживин Даниил")
@Feature("Сотрудники")
public class MasterTests extends TestBase {

    final MastersPage mastersPage = new MastersPage();

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
        String companyId = config.getCompanyId();

        mastersPage.openMastersPage(companyId)
                .clickAddMaster()
                .inputValueMaster(
                        masterData.getMasterName(),
                        masterData.getMasterSurname(),
                        masterData.getMasterPost())
                .clickSaveMaster()
                .fillProfileMaster(
                        masterData.getMasterPhoneNumber(),
                        masterData.getMasterEmail(),
                        masterData.getMasterInfo());
    }
}
