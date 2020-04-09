package com.example.songscatalog.ratings.service;

import com.example.songscatalog.ratings.dao.entity.Rating;
import com.example.songscatalog.ratings.dao.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongRatingsServiceImplementation implements SongRatingsService {
    private RatingRepository ratingRepository;
    @Autowired
    public SongRatingsServiceImplementation(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;

    }

    @Override
    public Rating getRatingByName(String songName) {
       return ratingRepository.getOne(songName);
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
