package com.utec.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BusinessViewHolder extends RecyclerView.Adapter<BusinessViewHolder.ViewHolder> {

    private static final String TAG ="recyler adapter";
    private ArrayList<String> mListView1 = new ArrayList<>();
    private ArrayList<String> mListView2 = new ArrayList<>();

    public BusinessViewHolder(ArrayList<String> mListView1, ArrayList<String> mListView2) {
        this.mListView1 = mListView1;
        this.mListView2 = mListView2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_business,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int i) {
        Log.d(TAG,"onbind");
        holder.t1.setText(mListView1.get(i));
        holder.t2.setText(mListView2.get(i));

    }



    @Override
    public int getItemCount() {
        return mListView1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView t1;
        TextView t2;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tvRazonS);
            t2 = itemView.findViewById(R.id.tvrolOf);
        }
    }
}

