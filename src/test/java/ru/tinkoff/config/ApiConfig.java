package ru.tinkoff.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface ApiConfig extends Config {
    @Key("api.base.url")
    @DefaultValue("https://cfg.tinkoff.ru/")
    String getBaseUrl();

    @Key("base.url.tinkoff")
    String getBaseURLTinkoff();

    @Key("api.url.tinkoff")
    String getApiURLTinkoff();
}
