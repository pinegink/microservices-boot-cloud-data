package com.example.songscatalog.catalog.controller;

import com.example.songscatalog.catalog.model.CatalogItem;
import com.example.songscatalog.catalog.service.SongsCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/songscatalog")
public class SongsCatalogController {
    private SongsCatalogService songsCatalogService;
    @Autowired
    public SongsCatalogController (SongsCatalogService songsCatalogService){
        this.songsCatalogService = songsCatalogService;
    }
    @GetMapping("/listsongs")
       public String listSongs (Model model){
        List<CatalogItem> catalogItems = songsCatalogService.getAllCatalogItems();
        model.addAttribute("catalog_items",catalogItems);
        return "listsongs";
    }
}
