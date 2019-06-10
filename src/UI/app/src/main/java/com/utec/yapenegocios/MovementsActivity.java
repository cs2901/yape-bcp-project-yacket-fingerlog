package com.utec.yapenegocios;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MovementsActivity extends AppCompatActivity{
   RecyclerView recyclerView;

     private  static final  String TAG = "fallo";
    DatabaseReference databaseReference;
     FirebaseRecyclerOptions<Movement> options;
    FirebaseRecyclerAdapter<Movement, MovementViewHolder> adapter;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.movements);

  recyclerView = findViewById(R.id.rvTransactions);

         FirebaseDatabase database = FirebaseDatabase.getInstance();


        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("movimientos")
                .limitToLast(50);

        options = new FirebaseRecyclerOptions.Builder<Movement>()
                        .setQuery(query, Movement.class)
                        .build();


        adapter = new FirebaseRecyclerAdapter<Movement, MovementViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MovementViewHolder holder, int position, @NonNull Movement model) {
                holder.bindTo(model);
            }

            @NonNull
            @Override
            public MovementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                return MovementViewHolder.create(parent);
            }


        };

        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }


  @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.stopListening();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e("OnStart", "OnStart");
    }

    @Override
    protected  void onStop(){
        super.onStop();

    }
    @Override
    protected void onResume(){
        super.onResume();
    }

}
