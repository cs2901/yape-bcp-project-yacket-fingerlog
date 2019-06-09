package com.utec.yapenegocios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeepCollaboratorActivity extends AppCompatActivity {

    private Intent intent;
    private String name;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_collaborator);
        intent = getIntent();
        name = intent.getStringExtra("collaboratorname");
        textView = findViewById(R.id.tvcollaboratorelimination);
        textView.setText(name);

    }

    public void OnClick(View view){
        Intent intent = new Intent(DeepCollaboratorActivity.this,ManageCollaboratorActivity.class);
        startActivity(intent);
    }

}
