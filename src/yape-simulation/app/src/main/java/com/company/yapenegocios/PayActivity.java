package com.company.yapenegocios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mDatabase;

    private Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initButton();

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void initButton(){
        button = (Button) findViewById(R.id.btpay);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view != null) {
            int id = view.getId();
            if (id == R.id.btpay) {
                submitCostumerData();
            }
        }
    }

    private void submitCostumerData() {
        String key = mDatabase.child("Customers").push().getKey();
        Customer customer = new Customer("77271231","Fernanditex");
        Map<String, Object> customerValue = customer.toMap();

        Map<String, Object> updates = new HashMap<>();
        updates.put("/Customers/"+key, customerValue);

        mDatabase.updateChildren(updates);
    }
}
