package com.spring.songlist.service;

import com.spring.songlist.model.AuthenticationRequest;
import com.spring.songlist.model.AuthenticationResponse;
import com.spring.songlist.util.JsonWebTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;

    private final JsonWebTokenUtils jwtUtils;

    public ResponseEntity<?> createToken(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String jwt = jwtUtils.generateToken(customUserDetailsService.loadUserByUsername(request.getUsername()));

            return ResponseEntity.status(HttpStatus.OK)
                    .body(AuthenticationResponse.tokenBuilder()
                            .token(jwt)
                            .status(String.valueOf(HttpStatus.OK))
                            .message("Exitoso")
                            .build());


        } catch (AuthenticationException authEx) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(AuthenticationResponse.tokenBuilder()
                            .status(String.valueOf(HttpStatus.UNAUTHORIZED))
                            .message("Acceso denegado, credenciales incorrectas")
                            .build());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(AuthenticationResponse.tokenBuilder()
                            .status(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR))
                            .message("Ha ocurrido un error en la autenticacion")
                            .build());
        }
    }
}
