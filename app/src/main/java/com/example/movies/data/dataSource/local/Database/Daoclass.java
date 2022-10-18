package com.example.movies.data.dataSource.local.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movies.data.model.Results;


@Dao
public interface Daoclass {

    @Insert
    void insertAllData(Results results);

    @Query("select * from Movie")
    Results getAllData();

}
