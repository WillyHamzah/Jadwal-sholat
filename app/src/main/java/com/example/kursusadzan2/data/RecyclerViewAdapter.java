package com.example.kursusadzan2.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kursusadzan2.R;
import com.example.kursusadzan2.data.model.AdzanResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<AdzanResponse.DataBean> jadwalList;

    public RecyclerViewAdapter(List<AdzanResponse.DataBean> jadwalList) {
        this.jadwalList = jadwalList;

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.subuh.setText(jadwalList.get(position).getTimings().getFajr());
        holder.duhur.setText(jadwalList.get(position).getTimings().getDhuhr());
        holder.azar.setText(jadwalList.get(position).getTimings().getAsr());
        holder.magrib.setText(jadwalList.get(position).getTimings().getMaghrib());
        holder.isya.setText(jadwalList.get(position).getTimings().getIsha());
        holder.tanggal.setText(jadwalList.get(position).getDate().getReadable());



    }

    @Override
    public int getItemCount() {
         return jadwalList.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
private TextView subuh, duhur, azar, magrib, isya, tanggal;

    public ViewHolder(View itemView) {
        super(itemView);
        tanggal = itemView.findViewById(R.id.tanggal);
        subuh = itemView.findViewById(R.id.time_subuh);
        duhur = itemView.findViewById(R.id.time_duhur);
        azar = itemView.findViewById(R.id.time_azar);
        magrib = itemView.findViewById(R.id.time_magrib);
        isya = itemView.findViewById(R.id.time_isya);

    }
}
}
