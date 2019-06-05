package com.example.yape_negocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ManageCollaboratorActivity extends AppCompatActivity {

    String[] dni = new String[]{"12836451","9761234","3764519","12394652"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_collaborator);

        ArrayAdapter<String> collaboratorListAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dni);
        ListView listCollaborator = (ListView)findViewById(R.id.lvlist_collaborators);
        listCollaborator.setAdapter(collaboratorListAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intent = new Intent(ManageCollaboratorActivity.this,MainActivity.class);
//                intent.putExtra(#.EXTRA_COLLABORATORID, (int)id);
                startActivity(intent);
            }
        };
    }

    public void onClickButton(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
