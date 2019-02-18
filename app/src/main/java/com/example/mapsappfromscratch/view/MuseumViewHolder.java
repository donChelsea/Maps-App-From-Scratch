package com.example.mapsappfromscratch.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mapsappfromscratch.MapsActivity;
import com.example.mapsappfromscratch.R;
import com.example.mapsappfromscratch.model.Museum;

public class MuseumViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView addressTextView;
    public static final String MUSEUM_NAME = "museum_name";
    public static final String MUSEUM_ADDRESS = "museum_address";

    public MuseumViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.museum_name_textview);
        addressTextView = itemView.findViewById(R.id.museum_address_text);
    }

    public void onBind(final Museum museum) {
        nameTextView.setText(museum.getName());
        addressTextView.setText(museum.getAddress());
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString(MUSEUM_NAME, museum.getName());
                args.putString(MUSEUM_ADDRESS, museum.getAddress());
                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                intent.putExtras(args);
                v.getContext().startActivity(intent);
            }
        });
    }
}
