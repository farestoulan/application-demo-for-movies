package com.example.movies;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.movies.Database.MovieModelClass;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "Movie")
public class Results {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @SerializedName("results")
    public List<MovieModelClass> results;

}