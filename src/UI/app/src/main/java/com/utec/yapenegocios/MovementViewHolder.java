package com.utec.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovementViewHolder extends RecyclerView.ViewHolder {

    public TextView t1;
    public TextView t2;

    public static MovementViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movement,parent,false);
        return new MovementViewHolder(view);
    }

    public MovementViewHolder(@NonNull View itemView) {
        super(itemView);
        t1 = itemView.findViewById(R.id.tvName);
        t2 = itemView.findViewById(R.id.tvFecha);
    }

    public void bindTo(Movement movement) {
        t1.setText(movement.getPor());
        t2.setText(movement.fecha + "");
    }
}