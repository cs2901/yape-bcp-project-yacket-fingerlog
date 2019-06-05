package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SelectBusinessActivity extends AppCompatActivity {
    String[] opciones = new String[]{"Coca cola","dona peta","la seno julia","tupa que tupa tupa tu papa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_business);

        ArrayAdapter<String>listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,opciones);
        ListView listBusiness = (ListView)findViewById(R.id.lvlist_business);
        listBusiness.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectBusinessActivity.this,MainActivity.class);
//                intent.putExtra(#.EXTRA_BUSSINESID, (int)id);
                startActivity(intent);
            }
        };
    }
}
