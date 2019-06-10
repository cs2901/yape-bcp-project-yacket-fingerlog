package com.utec.yapenegocios;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ColaboratorAccess extends AppCompatActivity {

    private static final String PIN2 = "con.utec.yapenegocios.PIN";
    DatabaseReference reference;
    private String Pin;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.make_payments);


        extracDatafromIntent();
        reference = FirebaseDatabase.getInstance().getReference().child("Register").child(Pin);

        System.out.println(reference);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



    }

    private void showData(DataSnapshot dataSnapshot) {
        String nameBusiness = dataSnapshot.child("nameBusiness").getValue().toString();
        String rolfOf = dataSnapshot.child("rolOf").getValue().toString();
        String email = dataSnapshot.child("email").getValue().toString();

        System.out.println("DATOS COLABORATOR");
        System.out.println(nameBusiness);
        System.out.println(rolfOf);
        System.out.println(email);
    }

    private void extracDatafromIntent() {
        Intent intent = getIntent();
        Pin = intent.getStringExtra(PIN2);
    }


    public static Intent makeIntenet(Context context,String Pin){
        Intent intent = new Intent(context,ColaboratorAccess.class);
        intent.putExtra(PIN2,Pin);
        return intent;
    }



}


