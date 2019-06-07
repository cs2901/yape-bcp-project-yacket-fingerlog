package com.company.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MovementsAdapter extends RecyclerView.ViewHolder {

    public TextView t1;


    public MovementsAdapter(@NonNull View itemView) {
        super(itemView);
        t1 = (TextView)itemView.findViewById(R.id.name);
    }
}
