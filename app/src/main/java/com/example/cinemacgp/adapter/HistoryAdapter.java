package com.example.cinemacgp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemacgp.R;
import com.example.cinemacgp.model.reservation.Reservation;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{
    private final Context ctx;
    private final ArrayList<Reservation> reservations;

    public HistoryAdapter(Context ctx, ArrayList<Reservation> reservations) {
        this.ctx = ctx;
        this.reservations = reservations;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.history_item,parent,false);

        Log.d("Lompat", "onCreateViewHolder: " +reservations.get(0).getUser().getName());

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.historyNumber.setText(reservations.get(position).getNumber().toString());
        holder.historyTitle.setText("Title : " + reservations.get(position).getMovieName());
        holder.historyName.setText("Person Name : " + reservations.get(position).getUser().getName());
        holder.historyDate.setText(reservations.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView historyTitle, historyName, historyNumber, historyDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            historyTitle = itemView.findViewById(R.id.historyTitle);
            historyDate = itemView.findViewById(R.id.historyDate);
            historyName = itemView.findViewById(R.id.historyName);
            historyNumber = itemView.findViewById(R.id.historyNumber);
        }
    }
}
