package com.utec.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ManageCollaboratorViewHolder extends RecyclerView.ViewHolder {

    public TextView collaboratorName;

    public ManageCollaboratorViewHolder(@NonNull View itemView) {
        super(itemView);

        collaboratorName = (TextView)itemView.findViewById(R.id.tvcollaborator);
    }
}
