package ru.dikidi.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class AuthResponse {
    private DataField data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class DataField {
        private Integer id;
        private String name;
        private String number;

        @JsonProperty("status_id")
        private Integer statusId;

        private String token;
        private Email email;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Email {
        private String value;
    }
}
