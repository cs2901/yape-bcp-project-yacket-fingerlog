package com.utec.yapenegocios;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ColaboratorAccessActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";
    DatabaseReference Payments,reference;
    private String Pin;
    String payMethod;
    int i = 0;
    Button ticket,invoice,payMent;
    ImageButton menuButton;
    Button generateQR;
    TextInputEditText items,amount;
    String nameBusiness,email,  ruc,direction,counting;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.make_payments);
        extracDatafromIntent();
        reference = FirebaseDatabase.getInstance().getReference().child("RegisterBusiness").child(Pin).child("1");
        ticket = findViewById(R.id.boleta);
        invoice = findViewById(R.id.factura);
        payMent = findViewById(R.id.pagar);
        items = findViewById(R.id.items);
        amount = findViewById(R.id.amount);
        menuButton = findViewById(R.id.searchImageButton);
        Payments = FirebaseDatabase.getInstance().getReference("Payments");
        System.out.println("References ");
        System.out.println(Payments);
        System.out.println(reference);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameBusiness = dataSnapshot.child("nameBusiness").getValue().toString();
                 email = dataSnapshot.child("email").getValue().toString();
                 ruc = dataSnapshot.child("ruc").getValue().toString();
               direction = dataSnapshot.child("direction").getValue().toString();
                System.out.println("Data recibido ");
               System.out.println(nameBusiness);
                System.out.println(email);
                System.out.println(ruc);
                System.out.println(direction);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColaboratorAccessActivity.this,menuActivity.class);
                intent.putExtra(ownerpin,Pin);
                startActivity(intent);

            }
        });

        payMent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Amount = amount.getText().toString();
                String Items = items.getText().toString();
                String method = payMethod;
                System.out.println("Onclick");
                System.out.println(Amount);
                System.out.println(Items);
                System.out.println(method);
                i = i +1;
                counting = String.valueOf(i);
                if(!TextUtils.isEmpty(counting)){
                    Payments pay = new Payments(Items,method,Amount,nameBusiness,ruc, email, direction);
                    Payments.child(counting).setValue(pay);
                }
                Intent intent = new Intent(ColaboratorAccessActivity.this, displayqrActivity.class);

                String dataForQR = nameBusiness+','+items.getText().toString()+','+amount.getText().toString()+','+email+','+direction;
                intent.putExtra("data",dataForQR);

                startActivity(intent);
            }
        });





        ticket.setOnClickListener(this);
        invoice.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boleta:
                invoice.setBackground(getResources().getDrawable(R.drawable.buttonyape));
                ticket.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setAlpha(1);
                payMethod = "Boleta";
                break;
            case R.id.factura:
                invoice.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                ticket.setBackground(getResources().getDrawable(R.drawable.buttonyape));
                payMent.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setAlpha(1);
                payMethod = "Factura";
                break;
        }
    }

    private void extracDatafromIntent() {
        Intent intent = getIntent();
        Pin = intent.getStringExtra(ownerpin);
    }


    public static Intent makeIntenet(Context context,String Pin){
        Intent intent = new Intent(context, ColaboratorAccessActivity.class);
        intent.putExtra(ownerpin,Pin);
        return intent;
    }



}


