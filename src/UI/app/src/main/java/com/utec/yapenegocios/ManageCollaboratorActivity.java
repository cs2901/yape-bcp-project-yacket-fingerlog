package com.utec.yapenegocios;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ManageCollaboratorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Collaborator> arrayList;
    private FirebaseRecyclerOptions<Collaborator> options;
    private FirebaseRecyclerAdapter<Collaborator,ManageCollaboratorViewHolder> adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_collaborator);
        recyclerView = findViewById(R.id.rvcollaborator);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<Collaborator>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("collaborator"); // complete!!!!
        databaseReference.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<Collaborator>().setQuery(databaseReference,Collaborator.class).build();


        adapter = new FirebaseRecyclerAdapter<Collaborator, ManageCollaboratorViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ManageCollaboratorViewHolder holder, int position, @NonNull final Collaborator model) {

                holder.collaboratorName.setText(model.getName());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =  new Intent(ManageCollaboratorActivity.this,DeepCollaboratorActivity.class);
                        intent.putExtra("collaboratorname",model.getName());
                        startActivity(intent);
                    }
                });



            }

            @NonNull
            @Override
            public ManageCollaboratorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new ManageCollaboratorViewHolder(LayoutInflater.from(ManageCollaboratorActivity.this).inflate(R.layout.row_collaborator,viewGroup,false));
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
