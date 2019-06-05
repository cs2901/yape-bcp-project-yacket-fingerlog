package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowCollaboratorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_collaborators);
    }
    public void onClickReturnMenu(View view){
        Intent i = new Intent(this,GetDataMenuActivity.class);
        startActivity(i);
    }
}
