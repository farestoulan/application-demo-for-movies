package com.example.movies;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.Database.Daoclass;

public class MovieViewModel extends AndroidViewModel {

    private final MutableLiveData<Results> volumesResponseLiveData;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        Repository repository = new Repository(application);
        volumesResponseLiveData = repository.getVolumesResponseLiveData();
    }

    public MutableLiveData<Results> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }

}