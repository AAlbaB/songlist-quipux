package com.spring.songlist.service.songlist;

import com.spring.songlist.exception.AlreadyExistsException;
import com.spring.songlist.model.SongList;
import com.spring.songlist.repository.SongListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongListService implements ISongListService {

    private final SongListRepository songListRepository;

    @Override
    public SongList addSongList(SongList songList) {
        return Optional.of(songList).filter(c -> !songListRepository.existsByName(c.getName()))
                .map(songListRepository::save)
                .orElseThrow(() -> new AlreadyExistsException(songList.getName() + " Already exists"));
    }
}
