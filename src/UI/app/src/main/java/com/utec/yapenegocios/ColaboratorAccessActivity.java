package com.utec.yapenegocios;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import top.defaults.drawabletoolbox.DrawableBuilder;

public class ColaboratorAccessActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";
    DatabaseReference Payments,reference;
    private String Pin;
    String payMethod;
    int i = 0;
    Button ticket,invoice,payMent;
    ImageButton menuButton;
    TextView business;
    private FloatingActionButton addItem;
    TextInputEditText items,amount;
    private ArrayList<TextInputEditText> newAddItemName = new ArrayList<TextInputEditText>();
    private ArrayList<TextInputEditText> newAddItemCost = new ArrayList<TextInputEditText>();
    String nameBusiness,email,  ruc,direction,counting,dni,rolOf;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.make_payments);
        extracDatafromIntent();
        reference = FirebaseDatabase.getInstance().getReference().child("Register").child(Pin).child("1");
        ticket = findViewById(R.id.boleta);
        invoice = findViewById(R.id.factura);
        payMent = findViewById(R.id.pagar);
        items = findViewById(R.id.items);
        addItem = findViewById(R.id.addItem);
        business = findViewById(R.id.Business);
        amount = findViewById(R.id.amount);
        menuButton = findViewById(R.id.searchImageButton);

        Payments = FirebaseDatabase.getInstance().getReference("Payments");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameBusiness = dataSnapshot.child("nameBusiness").getValue().toString();
                 email = dataSnapshot.child("email").getValue().toString();
                 ruc = dataSnapshot.child("ruc").getValue().toString();
               direction = dataSnapshot.child("direction").getValue().toString();
               dni = dataSnapshot.child("number").getValue().toString();
                rolOf = dataSnapshot.child("rolOf").getValue().toString();
                business.setText(nameBusiness);
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
                i = i + 1;
                counting = String.valueOf(i);
                if(!TextUtils.isEmpty(Pin)){
                    Payments pay = new Payments(Items,method,Amount,nameBusiness,ruc, email, direction,dni,rolOf);
                    Payments.child(Pin).child(counting).setValue(pay);
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


    @SuppressLint({"RestrictedApi", "WrongConstant"})
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boleta:
                invoice.setBackground(getResources().getDrawable(R.drawable.buttonyape));
                ticket.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setAlpha(1);
                addItem.setVisibility(View.VISIBLE);
                payMethod = "Boleta";
                addItem.setOnClickListener(new View.OnClickListener() {
                    int count = 1,count2 = 1;
                    @TargetApi(Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        final LinearLayout addMoreItems  = findViewById(R.id.moreitems);
                        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450,80);
                        params.setMargins(20,0, 100,0);
                        params.gravity = Gravity.CENTER_HORIZONTAL;
                        LinearLayout ll = new LinearLayout(getApplicationContext());
                        ll.setOrientation(LinearLayout.HORIZONTAL);
                        final TextInputEditText textInput = new TextInputEditText(getApplicationContext());


                        textInput.setId(count=count+1);
                        textInput.setLayoutParams(new LinearLayout.LayoutParams(450,73));
                        textInput.setPadding(25,0,0,2);
                        textInput.setBackground(getResources().getDrawable(R.drawable.borders_pay));
                        textInput.setHint("Item " + count);
                        textInput.setTextSize(18);
                        textInput.setAllCaps(false);
                        textInput.setTextColor(Color.rgb(0,0,0));
                        textInput.setHintTextColor(Color.argb(0.35F,0.0F,0.0F,0.0F));
                        newAddItemName.add(textInput);

                        final LinearLayout addPrices = findViewById(R.id.price);
                        final LinearLayout.LayoutParams priceparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80);
                        priceparams.gravity = Gravity.CENTER_HORIZONTAL;
                        LinearLayout prices = new LinearLayout(getApplicationContext());
                        prices.setOrientation((LinearLayout.VERTICAL));
                        final TextInputEditText textInput2 = new TextInputEditText(getApplicationContext());
                        textInput2.setId(count2=count2+1);
                        textInput2.setLayoutParams(params);
                        textInput2.setLayoutParams(new LinearLayout.LayoutParams(220,73));
                        textInput2.setPadding(25,0,0,2);
                        textInput2.setBackground(getResources().getDrawable(R.drawable.borders_pay));
                        textInput2.setHint("S/.");
                        textInput2.setTextSize(18);
                        textInput2.setAllCaps(false);
                        textInput2.setTextColor(Color.rgb(0,0,0));
                        textInput2.setHintTextColor(Color.argb(0.35F,0.0F,0.0F,0.0F));
                        newAddItemCost.add(textInput2);

                        ll.addView(textInput);
                        prices.addView(textInput2);
                        addMoreItems.addView(ll);
                        addPrices.addView(prices);
                    }
                });
                break;
            case R.id.factura:
                invoice.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                ticket.setBackground(getResources().getDrawable(R.drawable.buttonyape));
                payMent.setBackground(getResources().getDrawable(R.drawable.activatebutton));
                payMent.setAlpha(1);
                payMethod = "Factura";
                addItem.setVisibility(View.VISIBLE);
                addItem.setOnClickListener(new View.OnClickListener() {
                    int count = 1,count2 = 1;
                    @TargetApi(Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        final LinearLayout addMoreItems  = findViewById(R.id.moreitems);
                        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(450,80);
                        params.setMargins(20,0, 100,0);
                        params.gravity = Gravity.CENTER_HORIZONTAL;
                        LinearLayout ll = new LinearLayout(getApplicationContext());
                        ll.setOrientation(LinearLayout.HORIZONTAL);
                        final TextInputEditText textInput = new TextInputEditText(getApplicationContext());


                        textInput.setId(count=count+1);
                        textInput.setLayoutParams(new LinearLayout.LayoutParams(450,73));
                        textInput.setPadding(25,0,0,2);
                        textInput.setBackground(getResources().getDrawable(R.drawable.borders_pay));
                        textInput.setHint("Item " + count);
                        textInput.setTextSize(18);
                        textInput.setAllCaps(false);
                        textInput.setTextColor(Color.rgb(0,0,0));
                        textInput.setHintTextColor(Color.argb(0.35F,0.0F,0.0F,0.0F));
                        newAddItemName.add(textInput);

                        final LinearLayout addPrices = findViewById(R.id.price);
                        final LinearLayout.LayoutParams priceparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 80);
                        priceparams.gravity = Gravity.CENTER_HORIZONTAL;
                        LinearLayout prices = new LinearLayout(getApplicationContext());
                        prices.setOrientation((LinearLayout.VERTICAL));
                        final TextInputEditText textInput2 = new TextInputEditText(getApplicationContext());
                        textInput2.setId(count2=count2+1);
                        textInput2.setLayoutParams(params);
                        textInput2.setLayoutParams(new LinearLayout.LayoutParams(220,73));
                        textInput2.setPadding(25,0,0,2);
                        textInput2.setBackground(getResources().getDrawable(R.drawable.borders_pay));
                        textInput2.setHint("S/.");
                        textInput2.setTextSize(18);
                        textInput2.setAllCaps(false);
                        textInput2.setTextColor(Color.rgb(0,0,0));
                        textInput2.setHintTextColor(Color.argb(0.35F,0.0F,0.0F,0.0F));
                        newAddItemCost.add(textInput2);

                        ll.addView(textInput);
                        prices.addView(textInput2);
                        addMoreItems.addView(ll);
                        addPrices.addView(prices);
                    }
                });
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


