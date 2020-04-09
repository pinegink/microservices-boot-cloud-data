package com.example.songscatalog.catalog.rest.resource;

import com.example.songscatalog.catalog.model.CatalogItem;

import java.util.List;

public interface BandResource {
    public List<CatalogItem> getBandsBySongNames(List<String> names);
}
