package com.spring.songlist.controller;

import com.spring.songlist.model.GenericResponse;
import com.spring.songlist.model.SonListIndividualResponse;
import com.spring.songlist.model.SongList;
import com.spring.songlist.model.SongListResponse;
import com.spring.songlist.service.songlist.ISongListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lists")
public class SongListController {

    private final ISongListService songListService;

    @PostMapping
    public ResponseEntity<GenericResponse> addCategory(@Valid @RequestBody SongList songList) {
        SongList theSongList = songListService.addSongList(songList);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SonListIndividualResponse.songListBuilder()
                        .songlist(theSongList)
                        .status(String.valueOf(HttpStatus.CREATED))
                        .message("Exitoso")
                        .build());
    }

    @GetMapping
    public ResponseEntity<GenericResponse> getAllSongLists() {
        List<SongList> listsOfLists = songListService.getAllSongLists();

        return ResponseEntity.status(HttpStatus.OK)
                .body(SongListResponse.songListBuilder()
                        .songlists(listsOfLists)
                        .status(String.valueOf(HttpStatus.OK))
                        .message("Exitoso")
                        .build());
    }

    @GetMapping("/{listName}")
    public ResponseEntity<GenericResponse> getCategoryByName(@PathVariable String listName) {
        SongList theSongList = songListService.getSongListByName(listName);

        return ResponseEntity.status(HttpStatus.OK)
                .body(SonListIndividualResponse.songListBuilder()
                        .songlist(theSongList)
                        .status(String.valueOf(HttpStatus.OK))
                        .message("Exitoso")
                        .build());
    }
}
