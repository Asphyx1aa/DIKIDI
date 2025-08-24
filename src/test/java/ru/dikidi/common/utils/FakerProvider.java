package ru.dikidi.common.utils;

import net.datafaker.Faker;
import java.util.Locale;

public class FakerProvider {
    private static final Faker FAKER = new Faker(Locale.of("ru", "RU"));

    public static Faker getFaker() {
        return FAKER;
    }
}