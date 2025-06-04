package data;

import com.github.javafaker.Faker;
import config.TestsConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

@Getter
@AllArgsConstructor
public class MasterData {
    private final String masterName;
    private final String masterSurname;
    private final String masterPhoneNumber;
    private final String masterPost; //Должность
    private final String masterInfo;
    private final String masterEmail;

    private static final Faker faker = new Faker();

    public static MasterData fakeMasterData() {
        return new MasterData(
                faker.name().fullName(),
                faker.name().fullName(),
                "79" + faker.number().digits(9),
                faker.job().position(),
                faker.lorem().toString(),
                faker.internet().emailAddress()
        );
    }
}
