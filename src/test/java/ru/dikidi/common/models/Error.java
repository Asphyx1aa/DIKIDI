package ru.dikidi.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;
}
