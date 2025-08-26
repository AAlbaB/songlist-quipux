package com.spring.songlist.controller;

import com.spring.songlist.model.AuthenticationRequest;
import com.spring.songlist.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationService AuthService;

    @PostMapping(path = "/authenticate",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createToken(@Valid @RequestBody AuthenticationRequest request) {
        return AuthService.createToken(request);
    }
}
