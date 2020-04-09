package com.example.songscatalog.ratings.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "songs_ratings")
public class Rating {
    @Id
    @Column(name = "song_name")
    private String name;
    @Column(name = "rating")
    private int rating;

    public Rating() {
    }

    public String getName() {
        return name;
    }

    public void setName(String song) {
        this.name = song;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
