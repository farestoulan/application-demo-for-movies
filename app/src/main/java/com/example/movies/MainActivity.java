package com.example.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Results> call = apiInterface.getMovie();

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(@NonNull Call<Results> call,
                                   @NonNull Response<Results> response) {
                Adaptry adaptry = new Adaptry(MainActivity.this,
                        response.body().results);
                recyclerView.setAdapter(adaptry);

            }

            @Override
            public void onFailure(@NonNull Call<Results> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "erro", Toast.LENGTH_LONG).show();
            }

        });

    }

}