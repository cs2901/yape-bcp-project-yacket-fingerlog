package com.company.yapenegocios;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Start initialize database_ref
        mDatabase = FirebaseDatabase.getInstance().getReference().child("movimientos").child("prueba");

    }

    @Override
    public void onStart() {
        super.onStart();
        ValueEventListener movementsListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Movements movement = dataSnapshot.getValue(Movements.class);
                System.out.println("MONTO : "+movement.monto);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Reading movements", "loadMovements:onCancelled", databaseError.toException() );
            }
        };
        mDatabase.addValueEventListener(movementsListener);
    }

    public void readMovements() {

    }
}
