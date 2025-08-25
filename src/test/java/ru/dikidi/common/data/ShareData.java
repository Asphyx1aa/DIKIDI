package ru.dikidi.common.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.dikidi.common.utils.FakerProvider.getFaker;

@Getter
@AllArgsConstructor
public class ShareData {
    private final String titleShare;
    private final String descriptionShare;

    public static ShareData fakeShareData() {
        return new ShareData(
                getFaker().educator().toString(),
                getFaker().lorem().toString()
        );
    }
}
