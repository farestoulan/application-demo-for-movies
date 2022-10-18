package com.example.movies.Presentation.viewModel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.movies.data.repository.Repository;


public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final Repository repository;

    public MyViewModelFactory(Repository repository) {
        this.repository =repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass.isAssignableFrom(MovieViewModel.class)) {
             return (T) new  MovieViewModel(repository);
        } else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }

    }


}


