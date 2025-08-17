package ru.dikidi.online.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.dikidi.common.base.WebTestBase;
import ru.dikidi.online.pages.MainPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Тимур Власов")
@Feature("Поиск")
public class SearchTests extends WebTestBase {
    private final MainPage mainPage = new MainPage();

    @ParameterizedTest
    @ValueSource(strings = {
            "Компашка Наташки",
            "Расчет рейтинга"
    })
    @Severity(CRITICAL)
    @DisplayName("Поиск проекта по названию")
    void searchDisplaysCorrectResultTest(String companyName) {
        mainPage.openPage()
                .removeCookieBanner()
                .setValueInSearchField(companyName)
                .assertThatCorrectProjectWasFound(companyName);
    }
}
