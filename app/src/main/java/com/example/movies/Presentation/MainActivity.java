package com.example.movies.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movies.R;
import com.example.movies.Presentation.adapter.Adaptry;
import com.example.movies.data.dataSource.local.LocalDataSource;
import com.example.movies.data.dataSource.remote.RemotDataSource;
import com.example.movies.data.repository.Repository;
import com.example.movies.Presentation.viewModel.MovieViewModel;
import com.example.movies.Presentation.viewModel.MyViewModelFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyViewModelFactory viewModelFactory;
        RemotDataSource remotDataSource = new RemotDataSource();
        LocalDataSource localDataSource = new LocalDataSource(getApplicationContext());
        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recyclerView);
        Repository repository = new Repository(remotDataSource, localDataSource);
        viewModelFactory = new MyViewModelFactory(repository);
        MovieViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel.class);
        viewModel.getVolumesResponseLiveData().observe(this, results -> {
            if (results != null) {
                Adaptry adaptry = new Adaptry(MainActivity.this, results.results);
                recyclerView.setAdapter(adaptry);
            } else {
                textView.setText("Could not load data");
            }
        });
    }

}