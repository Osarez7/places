package com.example.juliosalddana.places.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.datamodels.Place;
import com.example.juliosalddana.places.model.repositories.PlacesRepository;

public class DetailActivity extends AppCompatActivity {

    public static final String PLACE_POSITION_KEY = "place_position_key";
    private int placePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();


        //Inflamos las vistas del layout
        TextView tvPlaceTitle = findViewById(R.id.tv_place_title);
        TextView tvtPlaceDescription  = findViewById(R.id.tv_place_description);
        ImageView ivPlace = findViewById(R.id.im_place);


        if (intent != null) {
            placePosition = intent.getIntExtra(PLACE_POSITION_KEY, 0);
            Place place  = PlacesRepository.getPlaceByPosition(placePosition);

            //Asignamos valores a las vistas
            tvPlaceTitle.setText(place.getName());
            tvtPlaceDescription.setText(place.getDescription());
            ivPlace.setImageResource(place.getImageId());
        }

;    }
}
