package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class PayActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Intent intent;
    private String qrData;
    TextView bussiness;
    TextView ammount;
    private Customer client;
    private String[] qrS;
    private String[] itemsS;
    private ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        intent = getIntent();
        qrData = intent.getStringExtra("qrdata");
        qrS = qrData.split(",");
        itemsS = qrS[1].split(" ");
        items = new ArrayList<String>(Arrays.asList(itemsS));
        //QR qr = new QR(qrS[0],items, qrS[2], qrS[3], qrS[4], qrS[5]);
        initButton();
        bussiness  = findViewById(R.id.nameBussiness);
        ammount = findViewById(R.id.ammount);
        bussiness.setText("Estas realizando un pago a "+qrS[0]);
        ammount.setText(qrS[2]);
        client = new Customer();
    }

    private void initButton() {
        this.button = (Button) findViewById(R.id.btpay);
        this.button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v != null) {
            int id = v.getId();
            if(id == R.id.btpay) {
                Intent intent = new Intent(PayActivity.this, MainActivity.class);
                startActivity(intent);
                String salida = "";
                for (int i = 0; i < items.size(); i++) {
                    salida += items.get(i) + "\n";
                }
                sendMailUsingSendGrid("noreply@yapenegocios.com", client.getCorreo(), "Comprobante de Pago",
                        "Hola  " + client.getName() + "\n" +
                                "Id: " + client.getId() + "\n" +
                                "Dir: " + client.getDir() + "\n" +
                                "Nombre de la empresa: "+qrS[0]+ "\n"+
                                "Productos:" + salida +
                                "TOTAL: " + qrS[2]
                        );
                sendMailUsingSendGrid("noreply@yapenegocios.com", qrS[4], "Comprobante de Pago",
                            "Hola "+ qrS[0]+ "\n"+
                                    "Has recibido el pago por parte de "+ client.getName()+"\n"+
                                    "Productos: "+ salida +
                                    "TOTAL:" + qrS[2] + "\n"
                        );
                Toast.makeText(getApplicationContext(), "sending mail", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendMailUsingSendGrid(String from,String to, String subject, String mailBody){
        Hashtable<String , String> params = new Hashtable<>();
        params.put("to",to);
        params.put("from",from);
        params.put("subject", subject);
        params.put("text",mailBody);

        SendGridAsyncTask email = new SendGridAsyncTask();
        try{
            email.execute(params);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
