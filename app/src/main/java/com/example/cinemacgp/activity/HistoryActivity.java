package com.example.cinemacgp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cinemacgp.R;
import com.example.cinemacgp.fragment.HistoryFragment;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button onGoing = findViewById(R.id.onGoingBtn);
        Button completed = findViewById(R.id.completedBtn);

        onGoing.setOnClickListener(view -> {
            onGoing.setBackgroundColor(Color.parseColor("#ff512e"));
            completed.setBackgroundColor(Color.parseColor("#ffffff"));
            loadFragment(new HistoryFragment("ongoing"));
        });

        completed.setOnClickListener(view -> {
            completed.setBackgroundColor(Color.parseColor("#96be25"));
            onGoing.setBackgroundColor(Color.parseColor("#ffffff"));
            loadFragment(new HistoryFragment("completed"));
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.historyFragmentContainer, fragment);
        transaction.commit();
    }
}