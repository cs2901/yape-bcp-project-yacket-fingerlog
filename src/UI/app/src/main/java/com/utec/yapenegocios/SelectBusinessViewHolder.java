package com.utec.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class SelectBusinessViewHolder extends RecyclerView.ViewHolder {

    public TextView businessName;
    public TextView businessRol;

    public SelectBusinessViewHolder(@NonNull View itemView) {
        super(itemView);

        businessName = itemView.findViewById(R.id.tvbusinessname);
        businessRol = itemView.findViewById(R.id.tvbusinessrol);
    }
}
