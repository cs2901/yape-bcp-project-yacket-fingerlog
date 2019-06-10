package com.utec.yapenegocios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;


public class RegisterActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private DatabaseReference oDatabase;
    String toast = "Cuenta registrada";
     private EditText nameField;
     private EditText rucField;
     private EditText accountField;
     private EditText addressField;
     private EditText emailField;
     private EditText PINField;
     private EditText numberPhoneField;
     private EditText colaboratorField;
     private Button submitPost;
     private Button onCancel;
     private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Register");
        oDatabase = FirebaseDatabase.getInstance().getReference("OwnerCollaborators");

        nameField = findViewById(R.id.nameBusiness);
        rucField = findViewById(R.id.ruc);
        accountField = findViewById(R.id.nAccount);
        addressField = findViewById(R.id.direction);
        emailField = findViewById(R.id.email);
        PINField = findViewById(R.id.PIN);
        numberPhoneField = findViewById(R.id.yourNumber);
        colaboratorField = findViewById(R.id.dniCollaborator);
        submitPost = findViewById(R.id.onSubmit);
        onCancel = findViewById(R.id.cancel_action);

        submitPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
                submitPost2();
                openLoginActivity();
                makeText(getApplicationContext(),toast, LENGTH_LONG).show();
            }
        });

        onCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
    }


    public void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void submitPost() {
        final String nameBusiness = nameField.getText().toString();
        final String ruc = rucField.getText().toString();
        final String nAccount = accountField.getText().toString();
        final String direction = addressField.getText().toString();
        final String email = emailField.getText().toString();
        final String PIN= PINField.getText().toString();
        final String dniCollaborator = colaboratorField.getText().toString();
        final String yourNumber = numberPhoneField.getText().toString();

        if(!TextUtils.isEmpty(PIN)){
            Register register = new Register(nameBusiness, ruc, nAccount, direction,email,PIN,yourNumber,dniCollaborator,"Owner");
            mDatabase.child(PIN).setValue(register);
        }

    }

    private void submitPost2() {

        final String dniCollaborator = colaboratorField.getText().toString();
        final String PIN = PINField.getText().toString();
        final String yourNumber = numberPhoneField.getText().toString();

        if(!TextUtils.isEmpty(PIN)){
            OwnerCollaborators registerOwner = new OwnerCollaborators(dniCollaborator,"Colaborador");
            oDatabase.child(PIN).setValue(registerOwner);
        }
    }
}

