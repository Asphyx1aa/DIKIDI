package TestData;

import config.TestsConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

@Getter
public class UserData {
    private static final TestsConfig authData = ConfigFactory.create(TestsConfig.class);

    private final String userNumber = authData.getUserPhone();
    private final String userPassword = authData.getUserPassword();
    private final String userName = authData.getUserName();
}
