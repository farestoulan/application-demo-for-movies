package com.example.movies.Presentation.viewModel;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.data.model.Results;
import com.example.movies.data.repository.Repository;

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