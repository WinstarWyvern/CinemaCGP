package com.example.cinemacgp.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cinemacgp.R;
import com.example.cinemacgp.fragment.MapsFragment;

public class MapsActivity extends AppCompatActivity {
    Button firstLocation, secondLocation;
    private Double longitude, latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        firstLocation = findViewById(R.id.btnFirstLocation);
        secondLocation = findViewById(R.id.btnSecondLocation);

        firstLocation.setOnClickListener(view -> {
            latitude = -6.193924061113853;
            longitude = 106.78813220277623;
            loadFragment(new MapsFragment(longitude, latitude));
        });

        secondLocation.setOnClickListener(view -> {
            latitude = -6.20175020412279;
            longitude = 106.78223868546155;
            loadFragment(new MapsFragment(longitude, latitude));
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.mapFragmentContainer, fragment);
        transaction.commit();
    }
}