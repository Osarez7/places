package com.example.juliosalddana.places.view.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.datamodels.Place;
import com.example.juliosalddana.places.model.repositories.PlacesRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceDetailFragment extends Fragment {


    public static final String ARG_PLACE_POSITION = "place_position" ;
    private int mPlacePosition;

    public PlaceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_place_detail, container, false);

        TextView tvPlaceTitle = view.findViewById(R.id.tv_place_title);
        TextView tvtPlaceDescription  = view.findViewById(R.id.tv_place_description);
        ImageView ivPlace = view.findViewById(R.id.im_place);

        Bundle bundle = getArguments();
        if(bundle != null){
          mPlacePosition =  bundle.getInt(ARG_PLACE_POSITION, 0);
        }

        Place place = PlacesRepository.getPlaceByPosition(mPlacePosition);
        //Asignamos valores a las vistas
        tvPlaceTitle.setText(place.getName());
        tvtPlaceDescription.setText(place.getDescription());
        ivPlace.setImageResource(place.getImageId());
        return view;
    }


    public static PlaceDetailFragment getInstance(int polacePosition){
        //Estamos creando un bundle con parametros y enviandolo a nuestro fragment
        PlaceDetailFragment placeDetailFragment = new PlaceDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PlaceDetailFragment.ARG_PLACE_POSITION,polacePosition );
        placeDetailFragment.setArguments(bundle);
        return placeDetailFragment;
    }
}
