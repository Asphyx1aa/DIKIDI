package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface TestsConfig extends Config {
    @Key("BASE_URL")
    String getBaseUrl();

    @Key("BROWSER")
    String getBrowser();

    @Key("USER_PHONE")
    String getUserPhone();

    @Key("USER_EMAIL")
    String getUserEmail();

    @Key("USER_PASSWORD")
    String getUserPassword();

    @Key("USER_NAME")
    String getUserName();

    @Key("COMPANY_URL")
    String getCompanyUrl();

    @Key("COMPANY_ID")
    String getCompanyId();
}
