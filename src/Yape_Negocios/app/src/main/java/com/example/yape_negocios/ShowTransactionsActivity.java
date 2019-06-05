package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowTransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_transactions);
    }
    public void onClickReturnMenu(View view){
        Intent i = new Intent(this,GetDataMenuActivity.class);
        startActivity(i);
    }
}
