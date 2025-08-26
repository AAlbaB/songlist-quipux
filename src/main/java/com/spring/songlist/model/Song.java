package com.spring.songlist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("titulo")
    @Column(nullable = false)
    private String title;

    @JsonProperty("artista")
    @Column(nullable = false)
    private String artist;

    @JsonProperty("album")
    private String album;

    @JsonProperty("anno")
    private String releaseYear;

    @JsonProperty("genero")
    private String genre;
}
