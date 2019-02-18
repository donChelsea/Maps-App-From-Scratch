package com.example.mapsappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MuseumList {
    @SerializedName("museums")
    private List<Museum> museumList;

    public MuseumList(List<Museum> museumList) {
        this.museumList = museumList;
    }

    public List<Museum> getMuseumList() {
        return museumList;
    }
}
