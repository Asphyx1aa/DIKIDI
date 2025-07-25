package ru.dikidi.common.helpers;


import org.aeonbits.owner.ConfigFactory;
import ru.dikidi.common.TestBase;
import ru.dikidi.common.config.TestsConfig;


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

