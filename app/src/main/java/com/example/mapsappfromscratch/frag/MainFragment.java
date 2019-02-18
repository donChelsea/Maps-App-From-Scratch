package com.example.mapsappfromscratch.frag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mapsappfromscratch.R;
import com.example.mapsappfromscratch.controller.MuseumAdapter;
import com.example.mapsappfromscratch.model.Museum;
import com.example.mapsappfromscratch.model.MuseumList;
import com.example.mapsappfromscratch.network.MuseumService;
import com.example.mapsappfromscratch.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private static final String TAG = "Main Fragment";
    private View rootView;
    RecyclerView recyclerView;
    Retrofit retrofit;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);

        retrofit = RetrofitSingleton.getInstance();
        MuseumService museumService = retrofit.create(MuseumService.class);
        Call<MuseumList> museumListCall = museumService.getMuseumList();
        museumListCall.enqueue(new Callback<MuseumList>() {
            @Override
            public void onResponse(Call<MuseumList> call, Response<MuseumList> response) {
                List<Museum> museums = response.body().getMuseumList();
                recyclerView.setAdapter(new MuseumAdapter(museums));
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<MuseumList> call, Throwable t) {
                Log.d(TAG, "onFailure: something went wrong");
            }
        });

        return rootView;
    }

}
