package ru.dikidi.common.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import static ru.dikidi.common.utils.FakerProvider.getFaker;

@Data
@AllArgsConstructor
public class ServiceData {
    private final String serviceTitle;
    private final String serviceDescription;
    private final double servicePrice;

    public static ServiceData fakeServiceData() {
        return new ServiceData(
                getFaker().commerce().productName(),
                getFaker().harryPotter().quote(),
                getFaker().number().randomDouble(2, 100, 999)
        );
    }
}
