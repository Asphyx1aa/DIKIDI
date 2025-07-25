package ru.dikidi.common.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.dikidi.common.utils.FakerProvider.getFaker;


@Getter
@AllArgsConstructor
public class MasterData {
    private final String masterName;
    private final String masterSurname;
    private final String masterPhoneNumber;
    private final String masterPost; //Должность
    private final String masterInfo;
    private final String masterEmail;


    public static MasterData fakeMasterData() {
        return new MasterData(
                getFaker().name().firstName(),
                getFaker().name().lastName(),
                "79" + getFaker().number().digits(9),
                getFaker().job().position(),
                getFaker().lorem().toString(),
                getFaker().internet().emailAddress()
        );
    }
}
