package com.example.movies;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.RoomDatabase;

import com.example.movies.Database.Daoclass;
import com.example.movies.Database.DatabaseClass;
import com.example.movies.Database.MovieModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Repository {


    private static final String BASE_URL = "https://api.themoviedb.org";
    Daoclass dao;
    DatabaseClass database;
    private final MutableLiveData<Results> volumesResponseLiveData;

    public Repository(Context context) {
        database = DatabaseClass.getDatabase(context);
        dao = database.getDao();

        volumesResponseLiveData = new MutableLiveData<Results>();
        if (dao.getAllData() != null) {
            volumesResponseLiveData.postValue(dao.getAllData());
        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            Call<Results> call = apiInterface.getMovie();
            call.enqueue(new Callback<Results>() {
                @Override
                public void onResponse(Call<Results> call, Response<Results> response) {
                    if (response.body() != null) {
                        dao.insertAllData(response.body());
                        volumesResponseLiveData.postValue(dao.getAllData());
                    }
                }

                @Override
                public void onFailure(Call<Results> call, Throwable t) {
                    volumesResponseLiveData.postValue(null);
                }
            });
        }


    }


    public MutableLiveData<Results> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }


}
