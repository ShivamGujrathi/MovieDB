package com.example.moviedb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("popular")
    Call<ModelMovies> getPopularMovies(@Query("api_key")String apiKey);

    @GET("{id}")
    Call<ModelMovieDetails>moviedetailModel(@Path("id") String stringId,
                                      @Query("api_key")String apikey);

}
