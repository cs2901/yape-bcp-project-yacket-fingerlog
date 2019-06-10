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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ColaboratorAccess extends AppCompatActivity implements View.OnClickListener{

    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";
    DatabaseReference Payments,reference;
    private String Pin  ;
    String payMethod;
    int i = 0;
    Button ticket,invoice,payMent;
    TextInputEditText items,amount;
    String nameBusiness,email,  ruc,direction,counting;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.make_payments);
        extracDatafromIntent();
        System.out.println("colaborator acces ");
        System.out.println(Pin);
        reference = FirebaseDatabase.getInstance().getReference().child("Register").child(Pin);
        ticket = findViewById(R.id.boleta);
        invoice = findViewById(R.id.factura);
        payMent = findViewById(R.id.pagar);
        items = findViewById(R.id.items);
        amount = findViewById(R.id.amount);

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
            }
        });

        ticket.setOnClickListener(this);
        invoice.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boleta:
                invoice.setBackgroundColor(Color.rgb(255,255,255));
                ticket.setBackgroundColor(Color.rgb(0,202,164));
                payMent.setBackgroundColor(Color.rgb(0,202,164));
                payMent.setAlpha(1);
                payMethod = "Boleta";
                break;
            case R.id.factura:
                invoice.setBackgroundColor(Color.rgb(0,202,164));
                ticket.setBackgroundColor(Color.rgb(255,255,255));
                payMent.setBackgroundColor(Color.rgb(0,202,164));
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
        Intent intent = new Intent(context,ColaboratorAccess.class);
        intent.putExtra(ownerpin,Pin);
        return intent;
    }



}


