package com.spring.songlist.repository;

import com.spring.songlist.model.SongList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SongListRepository extends JpaRepository<SongList, Long> {
    boolean existsByName(String name);

    SongList findByName(String name);

    void deleteByName(String name);
}
