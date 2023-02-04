package com.example.cinemacgp.rest;

import com.example.cinemacgp.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/now_playing")
    Call<Example> getNowMovies(
            @Query(value = "api_key", encoded = true) String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
