package com.example.songscatalog.ratings.service;

import com.example.songscatalog.ratings.dao.entity.Rating;

import java.util.List;

public interface SongRatingsService {
    public Rating getRatingByName (String songName);
    public List<Rating> findAll();
    public void saveRating(Rating rating);
}
