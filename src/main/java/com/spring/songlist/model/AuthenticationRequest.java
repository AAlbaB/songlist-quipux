package com.spring.songlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @JsonProperty("password")
    private String password;
}
