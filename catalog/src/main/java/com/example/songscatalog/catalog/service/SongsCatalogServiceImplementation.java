package com.example.songscatalog.catalog.service;

import com.example.songscatalog.catalog.dao.entity.Song;
import com.example.songscatalog.catalog.dao.repository.SongRepository;
import com.example.songscatalog.catalog.model.CatalogItem;
import com.example.songscatalog.catalog.rest.resource.BandResource;
import com.example.songscatalog.catalog.rest.resource.RatingResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SongsCatalogServiceImplementation implements SongsCatalogService {
    private SongRepository songRepository;
    private RatingResource ratingResource;
    private BandResource bandResource;
    private final String BANDS_SERVICE_FAILURE = "songs-bands-service not available";
    private final String RATINGS_SERVICE_FAILURE = "songs-ratings-service not available";
    @Autowired
    public SongsCatalogServiceImplementation(SongRepository songRepository, RatingResource ratingResource, BandResource bandResource) {
        this.songRepository = songRepository;
        this.ratingResource = ratingResource;
        this.bandResource = bandResource;
    }

    @Override
    public List<CatalogItem> getAllCatalogItems() {
        List<Song> songs = songRepository.findAll();
        List<String> names = extractNamex(songs);
        List<CatalogItem> bands = bandResource.getBandsBySongNames(names);
        List<CatalogItem> ratings = ratingResource.getRatingsBySongNames(names);
        return joinDetailsAndRatings(bands, ratings);
    }

    private List<String> extractNamex (List<Song> songs){
        return songs.stream()
                .map(song -> song.getName())
                .collect(Collectors.toList());
    }

    private List<CatalogItem> joinDetailsAndRatings (List<CatalogItem> bands, List<CatalogItem> ratings){
        if (bands.get(0).getName() == BANDS_SERVICE_FAILURE && ratings.get(0).getName() == RATINGS_SERVICE_FAILURE){
            return new ArrayList<>();
        }
        if (bands.get(0).getName() == BANDS_SERVICE_FAILURE){
            return  ratings;
        }
        if(ratings.get(0).getName() == RATINGS_SERVICE_FAILURE){
            return bands;
        }
        Map<String, CatalogItem> catalogItems = new HashMap<>();
        for (CatalogItem detail : bands){
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.setName(detail.getName());
            catalogItem.setBand(detail.getBand());
            catalogItems.put(catalogItem.getName(), catalogItem);
        }
        for (CatalogItem rating : ratings){
            CatalogItem catalogItem = catalogItems.get(rating.getName());
            catalogItem.setRating(rating.getRating());
            catalogItem.setName(rating.getName());
        }
        return new ArrayList<>(catalogItems.values());
    }
}
