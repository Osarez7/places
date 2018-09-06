package com.example.juliosalddana.places.view.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.juliosalddana.places.R;
import com.example.juliosalddana.places.view.Fragments.PlaceListFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment  placeListFragment =  fragmentManager.findFragmentById(R.id.container);
        if (placeListFragment == null) {
            placeListFragment = new PlaceListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.container,  placeListFragment)
                    .commit();
        }

    }


}
