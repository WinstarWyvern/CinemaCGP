package com.example.cinemacgp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cinemacgp.R;
import com.example.cinemacgp.model.movie.Result;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView movieTitle, movieDescription, movieOriginalTitle, movieReleaseDate, movieOriginalLanguage, movieRating;
    String title, description, poster, originalTitle, originalLanguage, releaseDate;
    ImageView moviePoster;
    Result result;
    Double rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movieTitle = findViewById(R.id.movieTitle);
        movieOriginalTitle = findViewById(R.id.movieOriginalTitle);
        movieDescription = findViewById(R.id.movieDescription);
        moviePoster = findViewById(R.id.movieImage);
        movieOriginalLanguage = findViewById(R.id.movieOriginalLanguage);
        movieReleaseDate = findViewById(R.id.movieReleaseDate);
        movieRating = findViewById(R.id.movieRating);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getTitle();
        originalTitle = result.getOriginalTitle();
        description = result.getOverview();
        poster = result.getPosterPath();
        originalLanguage = result.getOriginalLanguage();
        releaseDate = result.getReleaseDate();
        rating = result.getVoteAverage();

        movieTitle.setText(title);
        movieOriginalTitle.setText(originalTitle);
        movieDescription.setText(description);
        movieReleaseDate.setText(releaseDate);
        movieOriginalLanguage.setText(originalLanguage);
        movieRating.setText(String.valueOf(rating));

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185"+ poster)
                .into(moviePoster);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return super.onSupportNavigateUp();
    }
}