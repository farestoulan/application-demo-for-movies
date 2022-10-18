package com.example.movies.data.model;

import com.example.movies.data.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/3/movie/popular?api_key=890f69b773f18728feadc9e496d4667d")
     Call<Results> getMovie();
}
