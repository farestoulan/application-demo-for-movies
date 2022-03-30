package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("results")
    List<MovieModelClass> results;
}