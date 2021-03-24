package com.example.moviedb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
   public static Retrofit getRetrofit(){
      retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
              .baseUrl("https://api.themoviedb.org/3/movie/")
              .addConverterFactory(GsonConverterFactory.create())
              //.client(okHttpClient)
              .build();

      return retrofit;
   }

}


