package com.spring.songlist.service.songlist;

import com.spring.songlist.model.SongList;

import java.util.List;
import java.util.Optional;

public interface ISongListService {
    SongList addSongList(SongList songList);

    List<SongList> getAllSongLists();

    SongList getSongListByName(String name);

}
