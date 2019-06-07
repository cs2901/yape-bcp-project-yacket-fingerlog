package com.company.yapenegocios;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    private  static final  String TAG = "fallo";
    DatabaseReference databaseReference;
    FirebaseRecyclerOptions<Movement> options;
    FirebaseRecyclerAdapter<Movement,MovementsAdapter> adapter;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rvTransactions);
        recyclerView.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("movimientos").child("prueba");

        options = new FirebaseRecyclerOptions.Builder<Movement>()
                .setQuery(databaseReference,Movement.class).build();

        adapter = new FirebaseRecyclerAdapter<Movement, MovementsAdapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MovementsAdapter holder, int position, @NonNull Movement model) {
                holder.t1.setText(model.getMonto());
            }

            @NonNull
            @Override
            public MovementsAdapter onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movement,parent,false);
                return new MovementsAdapter(view);
            }


        };

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onStart(){
        super.onStart();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Movement movement = dataSnapshot.getValue(Movement.class);
                Log.w(String.valueOf(movement.getMonto()),String.valueOf(movement.getFecha()));
                System.out.println("hola 1");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(TAG,"no leyo.", databaseError.toException());
            }
        };
        databaseReference.addValueEventListener(postListener);
    }

    @Override
    protected  void onStop(){
        adapter.stopListening();
        super.onStop();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

}
