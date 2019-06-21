package com.utec.yapenegocios;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
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
     private FloatingActionButton addCollaborator;
     private ArrayList<String> newAddColaborator = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register);

        mDatabase = FirebaseDatabase.getInstance().getReference("Register");
        oDatabase = FirebaseDatabase.getInstance().getReference("OwnerCollaborators");

        System.out.println(mDatabase);
        System.out.println(oDatabase);

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
        addCollaborator = findViewById(R.id.addColla);
        System.out.println(findViewById(R.id.dniCollaborator).toString());
        final LinearLayout addColla = (LinearLayout) findViewById(R.id.addLinear);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,80);
        params.setMargins(200,200,200,200);
        addCollaborator.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                LinearLayout ll = new LinearLayout(getApplicationContext());
                ll.setOrientation(LinearLayout.VERTICAL);
                final TextInputEditText textInput = new TextInputEditText(getApplicationContext());
                textInput.setId(count=count+1);
                textInput.getLayoutParams();
                textInput.setLayoutParams(new LinearLayout.LayoutParams(750,73));
                textInput.setPadding(25,0,0,2);
                textInput.setBackground(getResources().getDrawable(R.drawable.my_border));
                textInput.setHint("Colaboradores");
                textInput.setTextSize(18);
                textInput.setAllCaps(false);
                textInput.setTextColor(Color.rgb(0,0,0));
                textInput.setHintTextColor(Color.argb(0.35F,0.0F,0.0F,0.0F));
                newAddColaborator.add(textInput.getEditableText().toString());
                System.out.println(newAddColaborator);

                ll.addView(textInput);
                addColla.addView(ll);

            }

        });


        submitPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
                submitPost2();
                makeText(getApplicationContext(),toast, LENGTH_LONG).show();
                openLoginActivity();
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
            Register register = new Register(nameBusiness, ruc, nAccount, direction,email,PIN,yourNumber,dniCollaborator,"Owner"/*,addNewCollaborator*/);
            mDatabase.child(PIN).setValue(register);
        }

    }

    private void submitPost2() {

        final String dniCollaborator = colaboratorField.getText().toString();
        final String PIN = PINField.getText().toString();


        if(!TextUtils.isEmpty(PIN)){
            OwnerCollaborators registerOwner = new OwnerCollaborators(dniCollaborator,"Colaborador");
            oDatabase.child(PIN).setValue(registerOwner);
        }
    }
}

