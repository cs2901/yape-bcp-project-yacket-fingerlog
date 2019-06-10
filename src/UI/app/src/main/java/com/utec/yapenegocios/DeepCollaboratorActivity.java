package com.utec.yapenegocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeepCollaboratorActivity extends AppCompatActivity {

    private Intent intent;
    private String pin;
    private String pin2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_collaborator);
        intent = getIntent();
        pin = intent.getStringExtra("ownerid");
        pin2 = intent.getStringExtra("collaboratorname");
        textView = findViewById(R.id.tvcollaboratorelimination);
        textView.setText(pin);

    }

    public void OnClick(View view){
        Intent intent = new Intent(DeepCollaboratorActivity.this,ManageCollaboratorActivity.class);
        intent.putExtra("ownerid",pin);
        deleteCollaborator(pin);
        startActivity(intent);
    }

    private void deleteCollaborator(String pin){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("OwnerCollaborators").child(pin).child("1");
        databaseReference.removeValue();

        Toast.makeText(this,"Colaborador Eliminado",Toast.LENGTH_LONG).show();
    }

}
