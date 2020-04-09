package com.example.songscatalog.songsbands.dto;

import java.util.List;

public class DtoList {
    private List<Dto> dtoList;

    public DtoList(List<Dto> dtoList) {
        this.dtoList = dtoList;
    }

    public DtoList() {
    }

    public List<Dto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<Dto> dtoList) {
        this.dtoList = dtoList;
    }
}
