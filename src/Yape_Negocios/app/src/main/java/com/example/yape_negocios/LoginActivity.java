package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickShowMenuPrivilege(View view){
        Intent showMenu = new Intent(this,GetDataMenuActivity.class);
        startActivity(showMenu);
     }
     public void onClickShowMenu(View view){
        Intent showMenu = new Intent(this,GetDataActivity.class);
        startActivity(showMenu);
     }

     public void onClickShowSignUp(View view){
        Intent showSignUp = new Intent(this,SignUpActivity.class);
        startActivity(showSignUp);
     }

}


