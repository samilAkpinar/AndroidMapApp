package com.samil.androidmapapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptor extends RecyclerView.Adapter<adaptor.ViewHolder> {

    ArrayList<Data> datas;

    public adaptor(ArrayList<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.card_view, parent,
                false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data t=datas.get(position);

        holder.txtName.setText(t.getName());
        holder.txtInformation.setText(t.getInformation() + " / " + t.getDescription());

        holder.layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NESNEYE TIKLANDIĞINDA İŞLEM YAPILSIN
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtInformation;
        public TextView txtDescription;
        public LinearLayout layout1;

        public ViewHolder(View itemView) {
            super(itemView);

            this.txtName = (TextView) itemView.findViewById(R.id.txtName);
            this.txtInformation = (TextView) itemView.findViewById(R.id.txtDescription);
            this.layout1 = (LinearLayout) itemView.findViewById(R.id.layout1);
        }
    }

}
