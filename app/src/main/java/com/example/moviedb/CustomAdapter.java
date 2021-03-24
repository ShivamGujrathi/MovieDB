package com.example.moviedb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewAdapter> {

    private ArrayList<ResultsItem> resultsItemss;
    private Context context;


    private String URL = "https://image.tmdb.org/t/p/w342";


//    private ArrayList<ModelMovies> moviesArrayList;

    CustomAdapter(Context context, ArrayList<ResultsItem> moviesArrayList) {
        this.context = context;
        this.resultsItemss = moviesArrayList;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        ViewAdapter viewAdapter = new ViewAdapter(view);
        return viewAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {

        final ResultsItem movie = resultsItemss.get(position);
        Glide.with(context)
                .load(URL+movie.getPosterPath()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MovieDetails.class);
                intent.putExtra("detail",movie.getId());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return resultsItemss.size();
    }

    public class ViewAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }

}

