package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

@Owner("Тимур Власов")
@Feature("search")
public class SearchTests extends TestBase {
    MainPage mainPage = new MainPage();

    @ParameterizedTest
    @ValueSource(strings = {
            "Компашка Наташки",
            "Расчет рейтинга"
    })
    @DisplayName("Проверка, что поиск возвращает, тот проект, который мы ищем")
    void searchShouldReturnCorrectProjectTest(String companyName) {
        mainPage.openPage()
                .setValueInSearchField(companyName)
                .assertThatCorrectProjectWasFound(companyName);
    }
}
