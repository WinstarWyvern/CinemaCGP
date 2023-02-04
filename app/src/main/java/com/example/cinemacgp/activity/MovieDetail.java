package com.example.cinemacgp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cinemacgp.R;
import com.example.cinemacgp.database.ReservationDatabase;
import com.example.cinemacgp.model.movie.Result;
import com.example.cinemacgp.model.reservation.Reservation;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    TextView movieTitle, movieDescription, movieOriginalTitle, movieReleaseDate, movieOriginalLanguage, movieRating;
    String title, description, poster, originalTitle, originalLanguage, releaseDate;
    ImageView moviePoster;
    Result result;
    Double rating;
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        assignElement();

        TextView bookNumber = findViewById(R.id.reservationNumber);
        TextView personName = findViewById(R.id.reservationPersonName);
        bookNumber.setText(String.valueOf(number));
        ImageButton previousArrow = findViewById(R.id.previousArrow);
        ImageButton nextArrow = findViewById(R.id.nextArrow);
        Button submitBtn = findViewById(R.id.submitBtn);
        ReservationDatabase reservationDatabase = ReservationDatabase.getInstance();

        bookNumber.setText(String.valueOf(number));
        previousArrow.setEnabled(false);

        nextArrow.setOnClickListener(view1 -> {
            number = number + 1;
            bookNumber.setText(String.valueOf(number));

            nextArrow.setEnabled(number != 5);
            previousArrow.setEnabled(number != 1);

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
            number = number - 1;
            bookNumber.setText(String.valueOf(number));

            nextArrow.setEnabled(number != 5);
            previousArrow.setEnabled(number != 1);

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

        submitBtn.setOnClickListener(view -> {
            Integer num = Integer.parseInt(bookNumber.getText().toString());
            String name = personName.getText().toString();
            reservationDatabase.addReservation(new Reservation(name,num, title));
            Log.d("jumlah", String.valueOf(reservationDatabase.getAllReservation().size()));

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void assignElement() {
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