package data;

import com.github.javafaker.Faker;
import config.TestsConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

@Getter
@AllArgsConstructor
public class UserData {
    private final String userNumber;
    private final String userPassword;
    private final String userName;
    private final String userMail;

    private static final Faker faker = new Faker();

    public static UserData fromConfig() {
        TestsConfig authData = ConfigFactory.create(TestsConfig.class);

        return new UserData(
                authData.getUserPhone(),
                authData.getUserPassword(),
                authData.getUserName(),
                authData.getUserEmail()
        );
    }

    public static UserData fakeUserData() {
        return new UserData(
                "79" + faker.number().digits(9),
                faker.internet().password(6, 10),
                faker.name().fullName(),
                faker.internet().emailAddress()
        );
    }
}
