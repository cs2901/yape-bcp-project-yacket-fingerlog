package com.utec.yapenegocios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ManageCollaboratorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Business> arrayList;
    private FirebaseRecyclerOptions<Business> options;
    private FirebaseRecyclerAdapter<Business,SelectBusinessViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_collaborator);
    }
}
