package com.example.movies.data.dataSource;

import androidx.lifecycle.MutableLiveData;

import com.example.movies.data.model.ApiInterface;
import com.example.movies.data.model.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemotDataSource {

    private static final String BASE_URL = "https://api.themoviedb.org";
    private MutableLiveData<Results> volumesResponseLiveData;

    public RemotDataSource() {

    }

    public Call<Results> remotData(Callback<Results> callback) {
        volumesResponseLiveData = new MutableLiveData<Results>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Results> call = apiInterface.getMovie();
        call.enqueue(callback);

        return call;
    }

}


