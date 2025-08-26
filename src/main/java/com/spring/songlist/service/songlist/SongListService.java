package com.spring.songlist.service.songlist;

import com.spring.songlist.exception.AlreadyExistsException;
import com.spring.songlist.exception.ResourceNotFoundException;
import com.spring.songlist.model.SongList;
import com.spring.songlist.repository.SongListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongListService implements ISongListService {

    private final SongListRepository songListRepository;

    @Override
    public SongList addSongList(SongList songList) {
        return Optional.of(songList).filter(c -> !songListRepository.existsByName(c.getName()))
                .map(songListRepository::save)
                .orElseThrow(() -> new AlreadyExistsException(songList.getName() + ": Lista ya existe"));
    }

    @Override
    public List<SongList> getAllSongLists() {
        return songListRepository.findAll();
    }


    @Override
    public SongList getSongListByName(String name) {
        SongList songList = songListRepository.findByName(name);
        if (songList == null) {
            throw new ResourceNotFoundException("Lista no encontrada: " + name);
        }
        return songList;
    }

    @Override
    @Transactional
    public void deleteSongListByName(String name) {
        SongList songList = songListRepository.findByName(name);
        if (songList == null) {
            throw new ResourceNotFoundException("Lista no encontrada: " + name);
        }
        songListRepository.deleteByName(name);
    }
}
