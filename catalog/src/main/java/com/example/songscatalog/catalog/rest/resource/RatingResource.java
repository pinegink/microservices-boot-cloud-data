package com.example.songscatalog.catalog.rest.resource;


import com.example.songscatalog.catalog.model.CatalogItem;
import java.util.List;

public interface RatingResource {
    public List<CatalogItem> getRatingsBySongNames (List<String> names);
}
