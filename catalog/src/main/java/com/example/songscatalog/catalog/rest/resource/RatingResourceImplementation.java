package com.example.songscatalog.catalog.rest.resource;

import com.example.songscatalog.catalog.dto.Dto;
import com.example.songscatalog.catalog.dto.DtoList;
import com.example.songscatalog.catalog.model.CatalogItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RatingResourceImplementation implements RatingResource {
    private RestTemplate restTemplate;
    private static final Logger LOGGER = Logger.getLogger(BandResourceImplementation.class.getName());
    private final String RATINGS_SERVICE_FAILURE = "songs-ratings-service not available";
    @Autowired
    public RatingResourceImplementation(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackRatingsBySongNames")
    public List<CatalogItem> getRatingsBySongNames(List<String> names) {
        DtoList dtoList = restTemplate.postForObject("http://songs-ratings-service/songscatalog/ratings-by-names/", names, DtoList.class );
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (Dto dto : dtoList.getDtoList()){
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.setName(dto.getName());
            catalogItem.setRating(dto.getRating());
            catalogItems.add(catalogItem);
        }
        return catalogItems;
    }
    public List<CatalogItem> getFallbackRatingsBySongNames (List<String> names){
        LOGGER.severe(RATINGS_SERVICE_FAILURE);
        List<CatalogItem> catalogItems = new ArrayList<>();
        CatalogItem catalogItem = new CatalogItem();
        catalogItem.setName(RATINGS_SERVICE_FAILURE);
        catalogItems.add(catalogItem);
        return catalogItems;
    }
}