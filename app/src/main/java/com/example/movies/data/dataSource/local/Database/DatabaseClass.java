package com.example.movies.data.dataSource.local.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.movies.data.model.Results;

@Database(entities = {Results.class} ,version = 1)
@TypeConverters({Converter.class})
public abstract class DatabaseClass extends RoomDatabase {

public abstract Daoclass getDao();
private static DatabaseClass instance;


public static DatabaseClass getDatabase( Context context){


    if (instance == null){
synchronized (DatabaseClass.class){
    instance = Room.databaseBuilder(context ,DatabaseClass.class ," DATABASE")
            .allowMainThreadQueries().build();
}
    }
    return instance;
}

}
