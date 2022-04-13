package com.example.movies;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel {

    private final Repository repository;

    public MovieViewModel(Repository repository) {
        super();
        this.repository = repository;
    }

    public MutableLiveData<Results> getVolumesResponseLiveData() {
        return repository.getdata();
    }

}