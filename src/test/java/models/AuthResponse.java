package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {

    private DataField data;

    @Data
    public class DataField {
        String id;
        String name;
        String status_id;
        String token;
    }
}
