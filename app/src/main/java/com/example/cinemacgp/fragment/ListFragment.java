package com.example.cinemacgp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cinemacgp.R;
import com.example.cinemacgp.adapter.MovieAdapter;
import com.example.cinemacgp.model.movie.Example;
import com.example.cinemacgp.model.movie.Result;
import com.example.cinemacgp.rest.ApiClient;
import com.example.cinemacgp.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ListFragment extends Fragment {
    private MovieAdapter adapter;
    RecyclerView recyclerView;
    private int page = 1;
    private int totalPages;

    private void getRetrofit(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String API_KEY = "2e642658089918c920af9adc5dd79a54";
        String LANGUAGE = "en-US";
        Call<Example> call = apiInterface.getNowMovies(API_KEY, LANGUAGE, page);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(@NonNull Call<Example> call, @NonNull retrofit2.Response<Example> response) {
                List<Result> movieList = response.body().getResults();
                totalPages = response.body().getTotalPages();
                adapter = new MovieAdapter(getContext(),movieList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView viewText = view.findViewById(R.id.pageIndex);
        ImageButton previousArrow = view.findViewById(R.id.previousArrow);
        ImageButton nextArrow = view.findViewById(R.id.nextArrow);

        viewText.setText(String.valueOf(page));
        previousArrow.setEnabled(false);
        recyclerView = view.findViewById(R.id.rvMovies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        nextArrow.setOnClickListener(view1 -> {
            page = page + 1;
            viewText.setText(String.valueOf(page));
            getRetrofit();

            nextArrow.setEnabled(page != totalPages);
            previousArrow.setEnabled(page != 1);

            if (nextArrow.isEnabled()) {
                nextArrow.setImageResource(R.drawable.enabled_next_icon);
            }
            else {
                nextArrow.setImageResource(R.drawable.disabled_next_icon);
            }

            if (previousArrow.isEnabled()) {
                previousArrow.setImageResource(R.drawable.enabled_previous_icon);
            }
            else {
                previousArrow.setImageResource(R.drawable.disabled_previous_icon);
            }
        });

        previousArrow.setOnClickListener(view12 -> {
            page = page - 1;
            viewText.setText(String.valueOf(page));
            getRetrofit();

            nextArrow.setEnabled(page != totalPages);
            previousArrow.setEnabled(page != 1);

            if (nextArrow.isEnabled()) {
                nextArrow.setImageResource(R.drawable.enabled_next_icon);
            }
            else {
                nextArrow.setImageResource(R.drawable.disabled_next_icon);
            }

            if (previousArrow.isEnabled()) {
                previousArrow.setImageResource(R.drawable.enabled_previous_icon);
            }
            else {
                previousArrow.setImageResource(R.drawable.disabled_previous_icon);
            }
        });

        getRetrofit();
    }
}