package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies.Database.MovieModelClass;

import java.util.List;

public class Adaptry extends RecyclerView.Adapter<Adaptry.MyViewHolder> {

     private final Context mContext;
     private final List<MovieModelClass> mData;


    public Adaptry(Context context,List<MovieModelClass>data) {

        this.mContext= context ;
        this.mData =data ;
    }

    @NonNull
    @Override
    public Adaptry.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptry.MyViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());

        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500/"+mData.get(position).getPoster_path())
                .into(holder.poster_path);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView poster_path;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name_txt);
            poster_path  = itemView.findViewById(R.id.imageView);
        }
    }


}
