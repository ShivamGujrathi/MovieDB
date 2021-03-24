package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetails extends AppCompatActivity {
    ImageView imageViewdetails;
    TextView titledetail,textViewtitle,textViewover;
    RatingBar ratingBardetails;
    private String URL = "https://image.tmdb.org/t/p/w342";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imageViewdetails = findViewById(R.id.imageViewdetails);
       // trailer=findViewById(R.id.trailer);
        titledetail = findViewById(R.id.textView_title_detail);
       // descdetail = findViewById(R.id.textView2_desc_details);
        ratingBardetails = findViewById(R.id.ratingBar_details);
        textViewtitle=findViewById(R.id.textView_title);
        textViewover=findViewById(R.id.textViewo);
        // GetDataFromIntent();
        moviedetail();
    }

    public void moviedetail() {
        UserService userService = ApiClient.getRetrofit().create(UserService.class);
        int id =getIntent().getIntExtra("detail",0);
      //  userService.moviedetailModel("33988f819627cc9e02fcecb7d1e7fa97").enqueue(new Callback<ModelMovies>()
        userService.moviedetailModel(String.valueOf(id),"33988f819627cc9e02fcecb7d1e7fa97").enqueue(new Callback<ModelMovieDetails>() {
            @Override
            public void onResponse(Call<ModelMovieDetails> call, Response<ModelMovieDetails> response) {
                Glide.with(MovieDetails.this).load(URL+response.body().getPosterPath()).into(imageViewdetails);
                textViewtitle.setText(response.body().getTitle());
                textViewover.setText(response.body().getOverview());

//                Toast.makeText(MovieDetails.this, response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelMovieDetails> call, Throwable t) {

            }
        });
    }

}