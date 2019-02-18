package com.example.mapsappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mapsappfromscratch.R;
import com.example.mapsappfromscratch.model.Museum;
import com.example.mapsappfromscratch.view.MuseumViewHolder;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {
    private List<Museum> museums;

    public MuseumAdapter(List<Museum> museums) {
        this.museums = museums;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.museum_list_view, viewGroup, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder museumViewHolder, int i) {
        museumViewHolder.onBind(museums.get(i));
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }
}
