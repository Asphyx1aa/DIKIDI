package ru.dikidi.common.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import ru.dikidi.common.config.TestsConfig;

import static ru.dikidi.common.utils.FakerProvider.getFaker;


@Getter
@AllArgsConstructor
public class UserData {
    private final String userNumber;
    private final String userPassword;
    private final String userName;
    private final String userMail;


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
                "79" + getFaker().number().digits(9),
                getFaker().internet().password(6, 10),
                getFaker().name().fullName(),
                getFaker().internet().emailAddress()
        );
    }
}
