package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GetDataMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data_menu);
    }

    public void onClickShowQr(View view){
        Intent showQr =  new Intent(this,ShowQrActivity.class);
        startActivity(showQr);
    }
    public void onClickShowCollaborators(View view){
        Intent showCo =  new Intent(this,ShowCollaboratorsActivity.class);
        startActivity(showCo);
    }
    public void onClickShowTransactions(View view){
        Intent showTr =  new Intent(this,ShowTransactionsActivity.class);
        startActivity(showTr);
    }
}
