package com.spring.songlist.service;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder encoder;

    @Value("${spring.jwt.user}")
    private String username;

    @Value("${spring.jwt.password}")
    private String password;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (username.equals(this.username)) {
            return new User(this.username, encoder.encode(password), new ArrayList<>());

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
