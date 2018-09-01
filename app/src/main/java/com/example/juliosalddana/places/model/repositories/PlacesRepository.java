package com.example.juliosalddana.places.model.repositories;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.datamodels.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesRepository {

    public static final List<Place> PLACES_LIST = new ArrayList<>();

    public static final void addPlace(Place place){
        PLACES_LIST.add(place);
    }

    static {
        PLACES_LIST.add(new Place(R.drawable.machu_picchu, R.string.machu_picchu_title, R.string.machu_picchu_description));
        PLACES_LIST.add(new Place(R.drawable.muralla_china, R.string.machu_picchu_title, R.string.machu_picchu_description));
    }

    public static Place getPlaceByPosition(int placePosition) {
        return PLACES_LIST.get(placePosition);
    }
}
