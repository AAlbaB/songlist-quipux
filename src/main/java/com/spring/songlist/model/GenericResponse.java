package com.spring.songlist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"message", "status"})
public class GenericResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private String status;

    @JsonProperty("timestamp")
    private final String timestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ZonedDateTime.now());

    public GenericResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String toJson() {
        return "{"
                + " \"message\":\"" + message + "\","
                + "\"status\":\"" + status + "\","
                + " \"timestamp\":\"" + timestamp + "\"}";
    }
}
