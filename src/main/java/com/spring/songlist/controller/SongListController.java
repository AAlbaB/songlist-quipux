package com.spring.songlist.controller;

import com.spring.songlist.model.GenericResponse;
import com.spring.songlist.model.SongList;
import com.spring.songlist.service.songlist.ISongListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lists")
public class SongListController {

    private final ISongListService songListService;

    @PostMapping
    public ResponseEntity<GenericResponse> addCategory(@Valid @RequestBody SongList songList) {

        SongList theSongList = songListService.addSongList(songList);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(GenericResponse.builder()
                        .status(HttpStatus.CREATED.toString())
                        .message(theSongList.toString())
                        .build());
    }
}
