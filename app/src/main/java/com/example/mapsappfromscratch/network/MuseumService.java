package com.example.mapsappfromscratch.network;

import com.example.mapsappfromscratch.model.MuseumList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumService {
    @GET("JDVila/storybook/master/museums.json")
    Call<MuseumList> getMuseumList();
}
