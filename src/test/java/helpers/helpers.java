package helpers;

import tests.web.TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class helpers {

    TestBase Base = new TestBase();
    final static TestsConfig config = ConfigFactory.create(TestsConfig.class);


    public static String extractUrl() {  // Вытягиваем номер проекта из url
        String url = url();  // Получаем текущий URL
        return url.substring(url.lastIndexOf("=") + 1); //Отправляем номер
    }

    public static String BilderURL(String point) {
        String Main = config.getMainАddress();
        String Language = config.getLANGUAGE();
        String ExtractURL = extractUrl();
        String URL = Main + Language + point + "?company=" + ExtractURL;
        return URL; //Собранный URL
    }


}

