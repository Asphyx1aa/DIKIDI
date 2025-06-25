package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface BrandConfig extends Config {
    @Key("PRIVACY_POLICY_URL_RU")
    String getPrivacyPolicyUrlRu();

    @Key("PRIVACY_POLICY_URL_EN")
    String getPrivacyPolicyUrlEn();

    @Key("ACTUAL_PROJECT_FIREBASE")
    String getActualProjectFirebase();

    @Key("AUTH_NAME")
    String getAuthName();

    @Key("AUTH_NUMBER")
    String getAuthNumber();

    @Key("AUTH_PASSWORD")
    String getAuthPassword();

    @Key("AGE_REGISTRATION_EMAIL")
    String getAgeRegistrationEmail();

}
