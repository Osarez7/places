package com.example.juliosalddana.places.view.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.repositories.PlacesRepository;
import com.example.juliosalddana.places.view.activities.DetailActivity;
import com.example.juliosalddana.places.view.adapters.PlacesAdapter;
import com.example.juliosalddana.places.view.adapters.PlacesEventListener;

public class PlaceListFragment  extends Fragment{


    private RecyclerView rvPlaces;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_list_layout, container, false);

        //lista de lugares
        rvPlaces = view.findViewById(R.id.rv_places);

        PlacesAdapter placesAdapter = new PlacesAdapter();
        rvPlaces.setAdapter(placesAdapter);
        rvPlaces.setLayoutManager(new LinearLayoutManager(getContext()));

        placesAdapter.setPlacesEventListener(placesEventListener);

        placesAdapter.setPlaceList(PlacesRepository.PLACES_LIST);
        placesAdapter.notifyDataSetChanged();

        return view;
    }

    private PlacesEventListener placesEventListener =  new PlacesEventListener() {
        @Override
        public void onSelectPlace(int placePosition) {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.PLACE_POSITION_KEY, placePosition);
            startActivity(intent);
        }
    };
}
