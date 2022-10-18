package com.example.movies.data.dataSource.local.Database;

import androidx.room.TypeConverter;

import com.example.movies.data.model.MovieModelClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converter {

    @TypeConverter
    public String fromResultList(List<MovieModelClass> results) {
        if (results == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<MovieModelClass>>() {}.getType();
        String json = gson.toJson(results, type);
        return json;
    }

    @TypeConverter
    public List<MovieModelClass> toResultList(String resultString) {
        if (resultString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<MovieModelClass>>() {}.getType();
        List<MovieModelClass> toResultList = gson.fromJson(resultString, type);
        return toResultList;
    }
}
