package com.spring.songlist.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SongList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty("descripcion")
    @NotBlank(message = "La descripcion es obligatoria")
    @Column(nullable = false)
    private String description;

    @JsonProperty("canciones")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "song_list_id")
    private List<Song> songs;
}
