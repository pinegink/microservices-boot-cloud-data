package com.example.songscatalog.ratings.dao.repository;

import com.example.songscatalog.ratings.dao.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, String> {
}
