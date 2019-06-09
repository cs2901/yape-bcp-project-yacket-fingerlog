package com.utec.yapenegocios;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.widget.Toast.*;


public class RegisterActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private DatabaseReference oDatabase;
    String toast = "Cuenta registrada";
     private EditText nameField;
     private EditText rucField;
     private EditText accountField;
     private EditText addressField;
     private EditText emailField;
     private EditText rolField;
     private EditText numberPhoneField;
     private EditText colaboratorField;
     private Button submitPost;
     private Button onCancel;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register);


        mDatabase = FirebaseDatabase.getInstance().getReference("Register");
        oDatabase = FirebaseDatabase.getInstance().getReference("OwnerCollaborators");

        nameField = findViewById(R.id.nameBusiness);
        rucField = findViewById(R.id.ruc);
        accountField = findViewById(R.id.nAccount);
        addressField = findViewById(R.id.direction);
        emailField = findViewById(R.id.email);
        rolField = findViewById(R.id.rol);
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
        final String rol= rolField.getText().toString();
        final String dniCollaborator = colaboratorField.getText().toString();
        final String yourNumber = numberPhoneField.getText().toString();

        if(!TextUtils.isEmpty(ruc)){
            Register register = new Register(nameBusiness, ruc, nAccount, direction,email,rol,yourNumber,dniCollaborator);
            mDatabase.child(ruc).setValue(register);
        }

    }

    private void submitPost2() {

        final String dniCollaborator = colaboratorField.getText().toString();
        final String yourNumber = numberPhoneField.getText().toString();

        if(!TextUtils.isEmpty(yourNumber)){
            OwnerCollaborators registerOwner = new OwnerCollaborators(yourNumber,dniCollaborator);
            oDatabase.child(yourNumber).setValue(registerOwner);
        }
    }
}

