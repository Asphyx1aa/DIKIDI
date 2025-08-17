package ru.dikidi.common.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import static ru.dikidi.common.utils.FakerProvider.getFaker;

@Data
@AllArgsConstructor
@Builder
public class ServiceData {
    private final String serviceTitle;
    private final String serviceDescription;
    private final double servicePrice;
    private final int category;
    private final boolean isFloating;
    private final boolean isOnline;
    private final int time;
    private final int breakDuration;
    private final Map<Integer, MasterData> masters;
    private final Map<Integer, String> gallery;


    public static ServiceData fakeServiceData() {
        return ServiceData.builder()
                .serviceTitle(getFaker().commerce().productName())
                .serviceDescription(getFaker().harryPotter().quote())
                .servicePrice(getFaker().number().randomDouble(2, 100, 999))
                .category(getFaker().number().numberBetween(20000, 39000))
                .isFloating(getFaker().bool().bool())
                .isOnline(getFaker().bool().bool())
                .time(30)
                .breakDuration(30)
                .build();
    }
}
