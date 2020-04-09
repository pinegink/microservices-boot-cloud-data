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
public class BandResourceImplementation implements BandResource {
    private RestTemplate restTemplate;
    private static final Logger LOGGER = Logger.getLogger(BandResourceImplementation.class.getName());
    private final String BANDS_SERVICE_FAILURE = "songs-bands-service not available";
    @Autowired
    public BandResourceImplementation(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @HystrixCommand(fallbackMethod = "getFallbackBandsBySongNames")
    @Override
    public List<CatalogItem> getBandsBySongNames(List<String> names) {
        DtoList dtoList = restTemplate.postForObject("http://songs-bands-service/songscatalog/bands-by-names/", names, DtoList.class);
        List<CatalogItem> catalogItems = new ArrayList<>();
        for (Dto dto : dtoList.getDtoList()){
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.setName(dto.getName());
            catalogItem.setBand(dto.getBand());
            catalogItems.add(catalogItem);
        }
        return catalogItems;
    }
    public List<CatalogItem> getFallbackBandsBySongNames (List<String> names){
        LOGGER.severe(BANDS_SERVICE_FAILURE);
        CatalogItem catalogItem = new CatalogItem();
        catalogItem.setName(BANDS_SERVICE_FAILURE);
        List<CatalogItem> catalogItems = new ArrayList<>();
        catalogItems.add(catalogItem);
        return catalogItems;
    }
}
