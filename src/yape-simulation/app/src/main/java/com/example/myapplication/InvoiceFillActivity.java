package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InvoiceFillActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    static private Customer cliente;

    public InvoiceFillActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_fill);
        initButton();
    }

    private void initButton(){
        this.button = (Button) findViewById(R.id.btguardar);
        this.button.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if(view != null) {

            int id = view.getId();
            if(id == R.id.btguardar) {

                final TextInputLayout nameField = (TextInputLayout) findViewById(R.id.TextEditName);
                String name = nameField.getEditText().getText().toString();
                final TextInputLayout dirField = (TextInputLayout) findViewById(R.id.TextEditDireccion);
                String dir = dirField.getEditText().getText().toString();
                final TextInputLayout idField = (TextInputLayout) findViewById(R.id.TextEditID);
                String id_ = idField.getEditText().getText().toString();
                final TextInputLayout correoField = (TextInputLayout) findViewById(R.id.TextEditCorreo);
                String correo = correoField.getEditText().getText().toString();

                System.out.println(correo);
                cliente = new Customer();
                cliente.setName(name);
                cliente.setId(id_);
                cliente.setDir(dir);
                cliente.setCorreo(correo);

                Intent intent = new  Intent(InvoiceFillActivity.this,  MainActivity.class);

                startActivity(intent);
            }
        }
    }
}