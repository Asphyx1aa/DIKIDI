package ru.dikidi.common.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectResponse {

    @JsonProperty("data")
    private ProjectData data;

    @JsonProperty("error")
    private Error error;
}