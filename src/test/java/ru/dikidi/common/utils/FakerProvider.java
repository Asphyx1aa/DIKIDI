package ru.dikidi.common.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerProvider {
    private static final Faker FAKER = new Faker(new Locale("en-GB"));

    public static Faker getFaker() {
        return FAKER;
    }
}
