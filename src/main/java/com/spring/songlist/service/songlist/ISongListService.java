package com.spring.songlist.service.songlist;

import com.spring.songlist.model.SongList;

import java.util.List;

public interface ISongListService {
    SongList addSongList(SongList songList);

    List<SongList> getAllSongLists();

    SongList getSongListByName(String name);

    void deleteSongListByName(String name);
}
