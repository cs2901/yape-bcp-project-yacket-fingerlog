package com.utec.yapenegocios;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SelectBusinessActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Business> arrayList;
    private FirebaseRecyclerOptions<Business>options;
    private FirebaseRecyclerAdapter<Business,SelectBusinessViewHolder>adapter;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_business);
        recyclerView = findViewById(R.id.rvbusiness);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Business>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("business");
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<Business>().setQuery(databaseReference,Business.class).build();


        adapter = new FirebaseRecyclerAdapter<Business, SelectBusinessViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SelectBusinessViewHolder holder, int position, @NonNull final Business model) {

                holder.businessName.setText(model.getName());
                holder.businessRol.setText(model.getRol());
//                holder.itemView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent =  new Intent(SelectBusinessActivity.this,Activity.class);
//                        intent.putExtra("businessname",model.getName());
//                        intent.putExtra("businessrol",model.getRol());
//                        startActivity(intent);
//                    }
//                });



            }

            @NonNull
            @Override
            public SelectBusinessViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new SelectBusinessViewHolder(LayoutInflater.from(SelectBusinessActivity.this).inflate(R.layout.row_business,viewGroup,false));
            }
        };


        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
