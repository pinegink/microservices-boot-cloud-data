package com.example.songscatalog.songsbands.dao.repository;

import com.example.songscatalog.songsbands.dao.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandsRepository extends JpaRepository<Details, String> {
}
