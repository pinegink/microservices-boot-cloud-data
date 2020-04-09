package com.example.songscatalog.songsbands.rest.server;

import com.example.songscatalog.songsbands.dao.model.Details;
import com.example.songscatalog.songsbands.dao.repository.BandsRepository;
import com.example.songscatalog.songsbands.dto.Dto;
import com.example.songscatalog.songsbands.dto.DtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songscatalog")
public class BandsRestController {
    private BandsRepository bandsRepository;
    @Autowired
    public BandsRestController(BandsRepository bandsRepository){
        this.bandsRepository = bandsRepository;
    }
    @PostMapping("/bands-by-names")
    public DtoList getBySongNames (@RequestBody List<String> names){
        List<Dto> dtos = new ArrayList<>();
        for (String name : names){
            Details details = bandsRepository.getOne(name);
            Dto dto = new Dto();
            dto.setName(details.getName());
            dto.setBand(details.getBand());
            dtos.add(dto);
        }
        DtoList dtoList = new DtoList(dtos);
        return dtoList;
    }
}
