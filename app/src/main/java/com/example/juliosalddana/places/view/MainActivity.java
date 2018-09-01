package com.example.juliosalddana.places.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.repositories.PlacesRepository;
import com.example.juliosalddana.places.view.adapters.PlacesAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lista de lugares
        rvPlaces = findViewById(R.id.rv_places);

        PlacesAdapter placesAdapter = new PlacesAdapter();
        rvPlaces.setAdapter(placesAdapter);
        rvPlaces.setLayoutManager(new LinearLayoutManager(this));

        placesAdapter.setPlaceList(PlacesRepository.PLACES_LIST);
        placesAdapter.notifyDataSetChanged();
    }
}
