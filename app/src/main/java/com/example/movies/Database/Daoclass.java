package com.example.movies.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Daoclass {

    @Insert
    void insertAllData(MovieModelClass  model);

    @Query("select * from Movie")
    List<MovieModelClass>getAllData();

}
