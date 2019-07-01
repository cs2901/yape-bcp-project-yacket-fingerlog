package com.utec.yapenegocios;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CardPaymentsActivity extends AppCompatActivity{


    private static final String TAG = "CardListActivity";
    private cardPaymentAdapter cardArrayAdapter;
    ArrayList<String> collaboratos = new ArrayList<String>();
    Button addCollaborator;
    ImageButton menuOption;
    private ListView listView;
    private DatabaseReference databaseReference;
    private String pin;
    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentes_layout);
        listView = (ListView) findViewById(R.id.myListPayments);


        Intent intent = getIntent();
        pin = intent.getStringExtra(ownerpin);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Payments").child(pin);
        System.out.println(databaseReference);
        databaseReference.keepSynced(true);

        addCollaborator = findViewById(R.id.addCollaborador);
        menuOption = findViewById(R.id.backButton);

        menuOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardPaymentsActivity.this,menuActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });
        cardArrayAdapter = new cardPaymentAdapter(getApplicationContext(), R.layout.list_item_card);


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                System.out.println("Hijos de db"+ dataSnapshot + databaseReference);

                String nameBusiness = dataSnapshot.child("nameBusiness").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();
                String ruc = dataSnapshot.child("ruc").getValue().toString();
                String direction = dataSnapshot.child("direction").getValue().toString();
                String  dni = dataSnapshot.child("dni").getValue().toString();
                String  rolOf = dataSnapshot.child("typeOfCollaborator").getValue().toString();
                String amout = dataSnapshot.child("amount").getValue().toString();
                String payMethod = dataSnapshot.child("payMethod").getValue().toString();
                String item = dataSnapshot.child("item").getValue().toString();
                Payments card = new Payments(item,payMethod,amout,nameBusiness,ruc,email, direction,dni,rolOf);
                cardArrayAdapter.add(card);
                listView.setAdapter(cardArrayAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
