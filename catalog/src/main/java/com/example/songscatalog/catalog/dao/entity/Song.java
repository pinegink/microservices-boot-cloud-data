package com.example.songscatalog.catalog.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @Column(name = "name")
    private String name;

    public Song() {
    }

    public String getName() {
        return name;
    }

    public void setName(String song) {
        this.name = song;
    }
}
