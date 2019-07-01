package com.utec.yapenegocios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity implements modalDialog.modalDialogListener {

    private static final String TAG = "CardListActivity";
    private CardArrayAdapter cardArrayAdapter;
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
        setContentView(R.layout.manage_listcollaborator);
        listView = (ListView) findViewById(R.id.myList);


        Intent intent = getIntent();
        pin = intent.getStringExtra(ownerpin);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Register").child(pin).child("1").child("addNewCollaborator");
        System.out.println(databaseReference);
        databaseReference.keepSynced(true);

        addCollaborator = findViewById(R.id.addCollaborador);
        menuOption = findViewById(R.id.backButton);

        menuOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardListActivity.this,menuActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });
        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);

        addCollaborator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }

        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String myChildValues = dataSnapshot.getValue(String.class);
                Card card = new Card(myChildValues);
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
    public void openDialog() {
        modalDialog exampleDialog = new modalDialog();
        exampleDialog.show(getSupportFragmentManager(),"HOLA");
    }




    @Override
    public void applyTexts(String username) {
        databaseReference.push().setValue(username);
    }

}