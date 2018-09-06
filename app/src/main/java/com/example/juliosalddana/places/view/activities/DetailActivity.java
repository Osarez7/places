package com.example.juliosalddana.places.view.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.model.datamodels.Place;
import com.example.juliosalddana.places.model.repositories.PlacesRepository;
import com.example.juliosalddana.places.view.Fragments.PlaceDetailFragment;
import com.example.juliosalddana.places.view.Fragments.PlaceListFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String PLACE_POSITION_KEY = "place_position_key";
    private int placePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            placePosition = intent.getIntExtra(PLACE_POSITION_KEY, 0);
        }


        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment  placedDetailFragment =  fragmentManager.findFragmentById(R.id.container);
        if (placedDetailFragment == null) {


            placedDetailFragment =  PlaceDetailFragment.getInstance(placePosition);


            fragmentManager
                    .beginTransaction()
                    .add(R.id.container,  placedDetailFragment)
                    .commit();
        }
   }
}
