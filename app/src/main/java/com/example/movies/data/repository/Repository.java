package com.example.movies.data.repository;


import androidx.lifecycle.MutableLiveData;

import com.example.movies.data.model.Results;
import com.example.movies.data.dataSource.LocalDataSource;
import com.example.movies.data.dataSource.RemotDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {
    private final RemotDataSource remote;
    private final LocalDataSource local;


    public Repository(RemotDataSource remote, LocalDataSource local) {
        this.remote = remote;
        this.local = local;

    }

    public MutableLiveData<Results> getdata() {
        MutableLiveData<Results> res = new MutableLiveData<>();
        if (local.getLocalData() != null) {
            res.postValue(local.getLocalData());

        }
        else {
            remote.remotData(new Callback<Results>() {
                @Override
                public void onResponse(Call<Results> call, Response<Results> response) {

                    if (response.body() != null) {
                        local.insertLocalData(response.body());
                        res.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Results> call, Throwable t) {


                    res.postValue(null);
                }
            });

       

        }
        return res;


    }

}




