package com.spring.songlist.service;

import com.spring.songlist.model.SpotifyTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyService {

    @Value("${spotify.api-authentication.url}")
    private String spotifyUrlAuth;

    @Value("${spotify.api-authentication.client-id}")
    private String spotifyClientId;

    @Value("${spotify.api-authentication.client-secret}")
    private String spotifyClienSecret;

    public String getAccessToken() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", spotifyClientId);
        formData.add("client_secret", spotifyClienSecret);

        HttpEntity<MultiValueMap<String, String>> tokenRequest = new HttpEntity<>(formData, headers);
        SpotifyTokenResponse tokenResponse = restTemplate.postForObject(spotifyUrlAuth, tokenRequest, SpotifyTokenResponse.class);

        if (tokenResponse == null) {
            throw new RuntimeException("No se pudo obtener el token de Spotify");
        }

        return tokenResponse.getAccessToken();
    }
}