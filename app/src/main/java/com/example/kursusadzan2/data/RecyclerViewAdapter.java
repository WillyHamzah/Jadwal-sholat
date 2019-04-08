package com.example.kursusadzan2.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kursusadzan2.R;
import com.example.kursusadzan2.data.model.AdzanResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<AdzanResponse> jadwalList;

    public RecyclerViewAdapter(List<AdzanResponse> jadwalList) {
        this.jadwalList = jadwalList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.subuh.setText(jadwalList.get(position).getCode());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

public class ViewHolder extends RecyclerView.ViewHolder {
private TextView subuh;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        subuh = itemView.findViewById(R.id.jadwal_subuh);

    }
}
}
