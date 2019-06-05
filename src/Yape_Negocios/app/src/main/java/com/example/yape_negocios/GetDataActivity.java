package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GetDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
    }
    public void onClickShowQr(View view){
        Intent showQr =  new Intent(this,ShowQrActivity.class);
        startActivity(showQr);
    }
}
