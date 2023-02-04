package com.example.cinemacgp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cinemacgp.R;
import com.example.cinemacgp.activity.MovieDetail;
import com.example.cinemacgp.model.movie.Result;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private final Context ctx;
    private final List<Result> resultList;

    public MovieAdapter(Context ctx, List<Result> resultList) {
        this.ctx = ctx;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item,parent,false);

        MovieAdapter.MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.linearLayout.setOnClickListener(view1 -> {
            Intent intent = new Intent(parent.getContext(), MovieDetail.class);
            Result result = new Result();

            result.setOriginalTitle(resultList.get(viewHolder.getBindingAdapterPosition()).getOriginalTitle());
            result.setOverview(resultList.get(viewHolder.getBindingAdapterPosition()).getOverview());
            result.setPosterPath(resultList.get(viewHolder.getBindingAdapterPosition()).getPosterPath());
            result.setTitle(resultList.get(viewHolder.getBindingAdapterPosition()).getTitle());
            result.setOriginalLanguage(resultList.get(viewHolder.getBindingAdapterPosition()).getOriginalLanguage());
            result.setReleaseDate(resultList.get(viewHolder.getBindingAdapterPosition()).getReleaseDate());
            result.setVoteAverage(resultList.get(viewHolder.getBindingAdapterPosition()).getVoteAverage());

            intent.putExtra(MovieDetail.EXTRA_MOVIE, result);
            parent.getContext().startActivity(intent);
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieTitle.setText(resultList.get(position).getTitle());
        holder.movieDesc.setText(resultList.get(position).getOverview());
        Glide.with(ctx).load("https://image.tmdb.org/t/p/w185" + resultList.get(position).getPosterPath()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView movieTitle, movieDesc, movieOriginalTitle, movieReleaseDate, movieOriginalLanguage, movieRating;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.moviePoster);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            movieDesc = itemView.findViewById(R.id.movieDescription);
            linearLayout = itemView.findViewById(R.id.layoutMovie);
            movieOriginalTitle = itemView.findViewById(R.id.movieOriginalTitle);
            movieReleaseDate = itemView.findViewById(R.id.movieReleaseDate);
            movieOriginalLanguage = itemView.findViewById(R.id.movieOriginalLanguage);
            movieRating = itemView.findViewById(R.id.movieRating);
        }
    }
}
