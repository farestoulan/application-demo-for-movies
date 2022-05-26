package com.example.movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/3/movie/popular?api_key=890f69b773f18728feadc9e496d4667d")
     Call<Results> getMovie();
}
