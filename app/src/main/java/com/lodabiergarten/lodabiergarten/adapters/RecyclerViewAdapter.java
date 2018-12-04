package com.lodabiergarten.lodabiergarten.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lodabiergarten.lodabiergarten.R;
import com.lodabiergarten.lodabiergarten.activities.BeerList;
import com.lodabiergarten.lodabiergarten.model.Beer;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    RequestOptions options;
    private Context mContext;
    private List<Beer> mData;


    public RecyclerViewAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop();
          //      .placeholder(R.drawable.loading)
         //       .error(R.drawable.loading);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.beer_row, parent, false);
        // click listener here
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.beer_name.setText(mData.get(position).getBeerName());
        holder.beer_rate.setText(mData.get(position).getRating());


        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.beerThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView beer_name, beer_rate;
        ImageView beerThumbnail;


        public MyViewHolder(View itemView) {
            super(itemView);
            beer_name = itemView.findViewById(R.id.rowname);
            beer_rate = itemView.findViewById(R.id.rating);
            beerThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
