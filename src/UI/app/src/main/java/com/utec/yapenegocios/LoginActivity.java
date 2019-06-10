package com.utec.yapenegocios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {

    private Button registerChange;
    private Button oneNumber;
    private Button twoNumber;
    private Button threeNumber;
    private Button fourNumber;
    private Button fiveNumber;
    private Button sixNumber;
    private Button sevenNumber;
    private Button eightNumber;
    private Button nineNumber;
    public static final String EXTRA_TEXT = "com.utec.yapenegocios.EXTRA_NAME";

    ArrayList<String> arrayList;
    private static final String TAG = "answoer";


    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);



        registerChange = findViewById(R.id.registerButton);
        oneNumber = findViewById(R.id.one);
        twoNumber = findViewById(R.id.two);
        threeNumber = findViewById(R.id.three);
        fourNumber = findViewById(R.id.four);
        fiveNumber = findViewById(R.id.five);
        sixNumber = findViewById(R.id.six);
        sevenNumber = findViewById(R.id.seven);
        eightNumber = findViewById(R.id.eight);
        nineNumber = findViewById(R.id.nine);
        arrayList = new ArrayList<String>();
        registerChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
        numberOneClicked();
        numberTwoClicked();
        numberThreeClicked();
        numberFourClicked();
        numberFiveClicked();
        numberSixClicked();
        numberSevenClicked();
        numberEightClicked();
        numberNineClicked();


    }



    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    public void numberOneClicked(){
        oneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = oneNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }


    public void numberTwoClicked() {
        twoNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = twoNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }

    public void numberThreeClicked() {
        threeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = threeNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }


    public void numberFourClicked() {
        fourNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = fourNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }

    public void numberFiveClicked() {
        fiveNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = fiveNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }

    public void numberSixClicked() {
        sixNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = sixNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }
    public void numberSevenClicked() {
        sevenNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = sevenNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }

    public void numberEightClicked() {
        eightNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = eightNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });
    }

    public void numberNineClicked() {
        nineNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = nineNumber.getText().toString();
                arrayList.add(result);
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });

    }
    private void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


    private void OpenMovementActiviy(){
        String loginIntro;
        loginIntro = loginList(arrayList);

        System.out.println(loginIntro);
        Intent intent = SelectBusinessActivity.makeIntent(LoginActivity.this,loginIntro);
        intent.putExtra(EXTRA_TEXT,loginIntro);
        startActivity(intent);

    }

    String loginList(ArrayList<String> list){
        String lisTologin = "";
        for(int i = 0; i < list.size();i++){
            lisTologin += list.get(i);
        }
        return lisTologin;
    }


}
