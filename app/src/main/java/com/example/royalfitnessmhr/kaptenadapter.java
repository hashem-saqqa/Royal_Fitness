package com.example.royalfitnessmhr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class kaptenadapter extends RecyclerView.Adapter<kaptenadapter.kaptenViewHolder> {
ArrayList<kapten> kaptens;


    public kaptenadapter(ArrayList<kapten> kaptens) {
        this.kaptens = kaptens;
    }

    @NonNull
    @Override
    public kaptenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v =   LayoutInflater.from(parent.getContext()).inflate(R.layout.kapten_item,null,false);
        kaptenViewHolder kaptenViewHolder = new kaptenViewHolder(v);
        return kaptenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull kaptenViewHolder holder, int position) {
        kapten k = kaptens.get(position);
        holder.im_view.setImageResource(k.getImg());
        holder.tv_name.setText(k.getName());

    }

    @Override
    public int getItemCount() {
        return kaptens.size();
    }

    class kaptenViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_name;
        ImageView im_view;

        public kaptenViewHolder(@NonNull View itemView) {

            super(itemView);
            tv_name= itemView.findViewById(R.id.textViewkapten);
            im_view= itemView.findViewById(R.id.imagekapten);
        }
    }
}
