package com.example.juliosalddana.places.view.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.view.Fragments.PlaceDetailFragment;
import com.example.juliosalddana.places.view.Fragments.PlaceListFragment;
import com.example.juliosalddana.places.view.adapters.PlacesEventListener;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment  placeListFragment =  fragmentManager.findFragmentById(R.id.container);
        if (placeListFragment == null) {
            placeListFragment = new PlaceListFragment();
            ((PlaceListFragment)placeListFragment).setPlacesEventListener(placeEventListener);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.container,  placeListFragment)
                    .commit();
        }else{
            ((PlaceListFragment)placeListFragment).setPlacesEventListener(placeEventListener);
        }

    }

    private PlacesEventListener placeEventListener = new PlacesEventListener() {
        @Override
        public void onSelectPlace(int placePosition) {
            View detailContainer = findViewById(R.id.detail_container);
            if(detailContainer != null){

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.detail_container,
                                PlaceDetailFragment.getInstance(placePosition))
                        .commit();

            }else{
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.PLACE_POSITION_KEY, placePosition);
                startActivity(intent);
            }
        }
    };



}
