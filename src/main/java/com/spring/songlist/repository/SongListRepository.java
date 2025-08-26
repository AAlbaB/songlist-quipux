package com.spring.songlist.repository;

import com.spring.songlist.model.SongList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongListRepository extends JpaRepository<SongList, Long> {
    boolean existsByName(String name);
}
