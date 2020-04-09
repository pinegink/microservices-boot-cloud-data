package com.example.songscatalog.ratings.rest.server;

import com.example.songscatalog.ratings.dao.entity.Rating;
import com.example.songscatalog.ratings.dto.Dto;
import com.example.songscatalog.ratings.dto.DtoList;
import com.example.songscatalog.ratings.service.SongRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songscatalog")
public class RatingRestController {
    private SongRatingsService songRatingsService;
    @Autowired
    public RatingRestController (SongRatingsService songRatingsService){
        this.songRatingsService = songRatingsService;
    }
    @PostMapping("/ratings-by-names")
    public DtoList getRatingsByNames (@RequestBody List<String> names){
        List<Dto> dtos = new ArrayList<>();
        for (String name : names){
            Rating rating = songRatingsService.getRatingByName(name);
            Dto dto = new Dto();
            dto.setName(rating.getName());
            dto.setRating(rating.getRating());
            dtos.add(dto);
        }
        DtoList dtoList= new DtoList(dtos);
        return dtoList;
    }
}
