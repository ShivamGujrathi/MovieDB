package com.example.moviedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    // UsersAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserService userService = ApiClient.getRetrofit().create(UserService.class);
        userService.getPopularMovies("33988f819627cc9e02fcecb7d1e7fa97").enqueue(new Callback<ModelMovies>() {

            @Override
            public void onResponse(Call<ModelMovies> call, Response<ModelMovies> response) {
                recyclerView = findViewById(R.id.recyclerview);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,3,RecyclerView.VERTICAL,false));
                recyclerView.setAdapter(new CustomAdapter(MainActivity.this,new ArrayList<ResultsItem>(response.body().getResults())));
               // Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelMovies> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}