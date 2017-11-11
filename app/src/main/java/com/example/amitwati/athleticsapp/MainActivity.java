package com.example.amitwati.athleticsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.main_toolbar);
        myToolbar.setTitle("אתלטי הנגב");
        setSupportActionBar(myToolbar);
    }

    public void tomenu(View view) {
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }
}
