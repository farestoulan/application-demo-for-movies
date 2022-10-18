package com.example.movies.data.dataSource.local;

import android.content.Context;

import com.example.movies.data.dataSource.local.Database.Daoclass;
import com.example.movies.data.dataSource.local.Database.DatabaseClass;
import com.example.movies.data.model.Results;

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


