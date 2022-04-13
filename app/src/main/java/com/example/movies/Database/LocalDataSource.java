package com.example.movies.Database;

import static okhttp3.internal.Internal.instance;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movies.Repository;
import com.example.movies.Results;

public class LocalDataSource {
    Daoclass dao;
    DatabaseClass databaseClass;


    public LocalDataSource(Context context) {
        databaseClass = DatabaseClass.getDatabase(context);
        dao = databaseClass.getDao();
    }

    public Results getLocalData() {
        return dao.getAllData();
    }

    public void insertLocalData(Results results) {
        dao.insertAllData(results);
    }

}


