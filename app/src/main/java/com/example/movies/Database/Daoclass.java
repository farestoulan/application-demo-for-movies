package com.example.movies.Database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movies.Results;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(Results  results);

    @Query("select * from Movie")
    Results getAllData();

}
