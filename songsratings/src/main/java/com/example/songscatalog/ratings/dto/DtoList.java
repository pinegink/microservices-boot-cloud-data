package com.example.songscatalog.ratings.dto;

import java.util.List;

public class DtoList {
    private List<Dto> dtoList;

    public DtoList() {
    }

    public DtoList(List<Dto> dtoList) {
        this.dtoList = dtoList;
    }

    public List<Dto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<Dto> dtoList) {
        this.dtoList = dtoList;
    }
}
