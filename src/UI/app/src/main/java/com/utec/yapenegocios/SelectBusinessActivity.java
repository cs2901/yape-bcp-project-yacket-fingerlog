package com.utec.yapenegocios;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectBusinessActivity extends AppCompatActivity {

    private static final String TEXT_PIN = "con.utec.yapenegocios.PIN2";
    DatabaseReference reference;
    ArrayList<String> LisName = new ArrayList<>();
    ArrayList<String> ListRol = new ArrayList<>();
    private Button button;
    private String Pin;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.business);

        extracDatafromIntent();

        reference = FirebaseDatabase.getInstance().getReference().child("Register").child(Pin);
        System.out.println(reference);

        button = (Button) findViewById(R.id.ButtonTo);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ColaboratorAccess.makeIntenet(SelectBusinessActivity.this, Pin);
                intent.putExtra(TEXT_PIN, Pin);
                startActivity(intent);
            }
        });

    }


    private void showData(DataSnapshot dataSnapshot) {
        String nameBusiness = dataSnapshot.child("nameBusiness").getValue().toString();
        String rolfOf = dataSnapshot.child("rolOf").getValue().toString();
        LisName.add(nameBusiness);
        ListRol.add(rolfOf);

        System.out.println(nameBusiness);
        System.out.println(rolfOf);

        iniRecyclerView();
    }

    private void iniRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rvBusiness);
        BusinessViewHolder adapter = new BusinessViewHolder(LisName, ListRol);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void extracDatafromIntent() {
        Intent intent = getIntent();
        Pin = intent.getStringExtra(TEXT_PIN);
    }


    public static Intent makeIntent(Context context, String PIN) {
        Intent intent = new Intent(context, SelectBusinessActivity.class);
        intent.putExtra(TEXT_PIN, PIN);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("OnStart", "OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

}
