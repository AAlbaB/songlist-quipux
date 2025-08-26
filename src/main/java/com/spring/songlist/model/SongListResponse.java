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
public class SongListResponse extends GenericResponse {

    @JsonProperty("listas_canciones")
    private List<SongList> songlists;

    @Builder(builderMethodName = "songListBuilder")
    public SongListResponse(String status, String message, List<SongList> songlists) {
        super(message, status);
        this.songlists = songlists;
    }
}
