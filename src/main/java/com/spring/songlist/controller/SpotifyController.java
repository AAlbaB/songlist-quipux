package com.spring.songlist.controller;

import com.spring.songlist.model.AuthenticationResponse;
import com.spring.songlist.service.SpotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/spotify")
public class SpotifyController {
    private final SpotifyService spotifyService;

    @GetMapping("/token")
    public ResponseEntity<AuthenticationResponse> getSpotifyToken() {
        String tokenSpotify = spotifyService.getAccessToken();

        return ResponseEntity.status(HttpStatus.OK)
                .body(AuthenticationResponse.tokenBuilder()
                        .token(tokenSpotify)
                        .status(String.valueOf(HttpStatus.OK))
                        .message("Exitoso")
                        .build());
    }
}