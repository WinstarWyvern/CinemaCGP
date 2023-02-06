package com.example.cinemacgp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;

import com.example.cinemacgp.R;
import com.example.cinemacgp.database.ReservationDatabase;
import com.example.cinemacgp.fragment.HistoryFragment;
import com.google.android.material.tabs.TabLayout;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button onGoing = findViewById(R.id.onGoingBtn);
        Button completed = findViewById(R.id.completedBtn);
        ReservationDatabase reservationDatabase = ReservationDatabase.getInstance();

        onGoing.setOnClickListener(view -> {
            onGoing.setBackgroundColor(Color.parseColor("#ff512e"));
            completed.setBackgroundColor(Color.parseColor("#ffffff"));
            loadFragment(new HistoryFragment(reservationDatabase.getReservationsByNameOnGoing("Andi")));
        });

        completed.setOnClickListener(view -> {
            completed.setBackgroundColor(Color.parseColor("#96be25"));
            onGoing.setBackgroundColor(Color.parseColor("#ffffff"));
            loadFragment(new HistoryFragment(reservationDatabase.getReservationsByNameOnGoing("Andi")));
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.historyFragmentContainer, fragment);
        transaction.commit();
    }
}