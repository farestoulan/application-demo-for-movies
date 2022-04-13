package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.movies.Database.LocalDataSource;
import com.example.movies.Database.MyViewModelFactory;
import com.example.movies.Database.RemotDataSource;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView;
        TextView textView;
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