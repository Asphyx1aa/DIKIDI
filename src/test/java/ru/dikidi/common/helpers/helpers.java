package ru.dikidi.common.helpers;


import org.aeonbits.owner.ConfigFactory;
import ru.dikidi.common.config.TestsConfig;

import static com.codeborne.selenide.WebDriverRunner.url;

public class helpers {

    final static TestsConfig config = ConfigFactory.create(TestsConfig.class);


    public static String ExtractID() {  // Вытягиваем номер проекта из url
        String url = url();  // Получаем текущий URL
        return url.substring(url.lastIndexOf("=") + 1);
    }

    public static String BuilderURL(String point) {
        String Main = config.getMainАddress();
        String Language = config.getLANGUAGE();
        String ExtractURL = ExtractID();
        return Main + Language + point + "?company=" + ExtractURL; //Собранный URL

        //Пример использывания
    }


}

