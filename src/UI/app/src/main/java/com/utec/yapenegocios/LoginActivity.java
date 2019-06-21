package com.utec.yapenegocios;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
    private Button ceroNumber;
    private TextView first;
    private TextView second;
    private TextView third;
    private TextView four;
    private TextView five;
    private TextView six;
    private DatabaseReference databaseReference;
    private ImageButton delete;
    public static final String ownerpin = "com.utec.yapenegocios.EXTRA_NAME";

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
        ceroNumber = findViewById(R.id.eleven);
        delete = findViewById(R.id.delete);
        first = findViewById(R.id.firstCircle);
        second = findViewById(R.id.secondCircle);
        third = findViewById(R.id.thirdCircle);
        four = findViewById(R.id.fourthCircle);
        five = findViewById(R.id.fifthCircle);
        six = findViewById(R.id.sixCircle);
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
        numberCeroClicked();
        deleteClick();

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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
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
                onClickDraw();
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });

    }

    public void numberCeroClicked() {
        ceroNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = ceroNumber.getText().toString();
                arrayList.add(result);
                onClickDraw();
                if(arrayList.size()==6){
                    OpenMovementActiviy();
                }
            }
        });

    }

    public void deleteClick() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(arrayList.size()==1){
                    first.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(arrayList.size()==2){
                    second.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(arrayList.size()==3){
                    third.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(arrayList.size()==4){
                    four.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(arrayList.size()==5){
                    five.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(arrayList.size()==6){
                    six.setBackground(getResources().getDrawable(R.drawable.circle2));
                }
                if(!arrayList.isEmpty()){
                    System.out.println("click with iteam");
                    arrayList.remove(arrayList.size()-1);
                }
                System.out.println("NO ITEMS");
            }
        });

    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


    private void OpenMovementActiviy(){
        final String loginIntro;
        loginIntro = loginList(arrayList);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Register").child(loginIntro);
        System.out.println("DATABASE REFERENCE");
        System.out.println((databaseReference));
        System.out.println(loginIntro);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Intent intent = new Intent(LoginActivity.this, SelectBusinessActivity.class);
                    intent.putExtra(ownerpin, loginIntro);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickDraw(){
        if(arrayList.size()==1){
            first.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
        if(arrayList.size()==2){
            second.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
        if(arrayList.size()==3){
            third.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
        if(arrayList.size()==4){
            four.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
        if(arrayList.size()==5){
            five.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
        if(arrayList.size()==6){
            six.setBackground(getResources().getDrawable(R.drawable.notempty));
        }
    }

    String loginList(ArrayList<String> list){
        String lisTologin = "";
        for(int i = 0; i < list.size();i++){
            lisTologin += list.get(i);
        }
        return lisTologin;
    }


}
