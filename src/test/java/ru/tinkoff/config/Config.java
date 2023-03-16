package ru.tinkoff.config;

import org.aeonbits.owner.ConfigFactory;

public class Config {
    private static ApiConfig config() {
        return ConfigFactory.newInstance().create(ApiConfig.class);
    }

    public static String baseURL() {
        return config().getBaseUrl();
    }

    public static String baseURLTinkoff() {
        return config().getBaseURLTinkoff();
    }

    public static String apiURLTinkoff() {
        return config().getApiURLTinkoff();
    }

}
