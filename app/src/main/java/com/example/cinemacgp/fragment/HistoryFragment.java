package com.example.cinemacgp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemacgp.R;
import com.example.cinemacgp.adapter.HistoryAdapter;
import com.example.cinemacgp.database.ReservationDatabase;
import com.example.cinemacgp.database.UserDatabase;
import com.example.cinemacgp.model.reservation.Reservation;
import com.example.cinemacgp.model.user.User;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    private String type;
    private RecyclerView recyclerView;
    private HistoryAdapter adapter;
    public HistoryFragment(String type) {
        this.type = type;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvHistory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        UserDatabase userDatabase = UserDatabase.getInstance();
        User currentUser = userDatabase.getUsers().get(0); // Get Andi

        ReservationDatabase reservationDatabase = ReservationDatabase.getInstance();
        ArrayList<Reservation> reservations;

        if(type.equalsIgnoreCase("ongoing")) {
            reservations = reservationDatabase.getReservationsByNameOnGoing(currentUser.getName());
        }
        else {
            reservations = reservationDatabase.getReservationsByNameCompleted(currentUser.getName());
        }

        if(reservations.size() == 0) {
            Toast.makeText(getContext(), "There is no booking yet", Toast.LENGTH_SHORT).show();
        }

        adapter = new HistoryAdapter(getContext(), reservations);
        recyclerView.setAdapter(adapter);
    }
}