package com.spring.songlist.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SonListIndividualResponse extends GenericResponse {

    @JsonProperty("lista_canciones")
    private SongList songlist;

    @Builder(builderMethodName = "songListBuilder")
    public SonListIndividualResponse(String status, String message, SongList songlist) {
        super(message, status);
        this.songlist = songlist;
    }
}
