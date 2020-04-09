package com.example.songscatalog.catalog.dao.repository;

import com.example.songscatalog.catalog.dao.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {
}
