package com.utec.yapenegocios;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class MovementsActivity extends AppCompatActivity{
   RecyclerView recyclerView;

   ImageButton menuOption;
    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";
    private String pin;
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

         menuOption = findViewById(R.id.searchImageButton);

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("movimientos")
                .limitToLast(50);

        options = new FirebaseRecyclerOptions.Builder<Movement>()
                        .setQuery(query, Movement.class)
                        .build();

        menuOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovementsActivity.this,menuActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });

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
