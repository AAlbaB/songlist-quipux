package com.spring.songlist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationResponse extends GenericResponse {

    @JsonProperty("token")
    private String token;

    @Builder(builderMethodName = "tokenBuilder")
    public AuthenticationResponse(String status, String message, String token) {
        super(message, status);
        this.token = token;
    }
}
