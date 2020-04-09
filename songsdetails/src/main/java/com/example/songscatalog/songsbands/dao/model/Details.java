package com.example.songscatalog.songsbands.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "songs_details")
public class Details {
    @Id
    @Column(name = "song_name")
    private String name;
    @Column(name = "band_name")
    private String band;

    public Details() {
    }

    public String getName() {
        return name;
    }

    public void setName(String song) {
        this.name = song;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
