package com.utec.yapenegocios;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    private static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";
    private String pin;
    Button notifications, colaborators,move,settings,profiles,sigout;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.menu);

        extracDatafromIntent();
        notifications = findViewById(R.id.notificaciones);
        colaborators = findViewById(R.id.colaboradores);
        move = findViewById(R.id.movimientos);
        sigout = findViewById(R.id.cerrarSesion);


        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, MovementsActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });


        colaborators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, ManageCollaboratorActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, MovementsActivity.class);
                intent.putExtra(ownerpin,pin);
                startActivity(intent);
            }
        });

        sigout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void extracDatafromIntent() {
        Intent intent = getIntent();
        pin = intent.getStringExtra(ownerpin);
    }

}
