package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

@Owner("Тимур Власов")
@Feature("Поиск")
public class SearchTests extends TestBase {
    final MainPage mainPage = new MainPage();

    @ParameterizedTest
    @ValueSource(strings = {
            "Компашка Наташки",
            "Расчет рейтинга"
    })
    @DisplayName("Проверка, что поиск возвращает, тот проект, который мы ищем")
    void searchShouldReturnCorrectProjectTest(String companyName) {
        mainPage.openPage()
                .removeCookieBanner()
                .setValueInSearchField(companyName)
                .assertThatCorrectProjectWasFound(companyName);
    }
}
