package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowQrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qr);
    }
    public void onClickReturnMenuPrivilege(View view){
        Intent returnMenu = new Intent(this,GetDataMenuActivity.class);
        startActivity(returnMenu);
    }
    public void onClickReturnMenu(View view){
        Intent returnMenu = new Intent(this,GetDataActivity.class);
        startActivity(returnMenu);
    }
}
