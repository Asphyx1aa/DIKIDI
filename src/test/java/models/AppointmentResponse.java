package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentResponse {
    private DataField data;
    private Appointment list;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataField {
        private List<Appointment> list;
    }

    @Data
    public static class Appointment {
        private String id;
    }
}
