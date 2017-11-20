package com.example.amitwati.athleticsapp;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by omri on 11/20/17.
 */

public class AthletesMeasurmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.athletes_contest_measurements);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_RED));
        }
        Toolbar myToolbar = findViewById(R.id.main_toolbar);
        myToolbar.setTitle("מדידות");
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary_RED));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Button CEbtn=(Button)findViewById(R.id.button1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CEbtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_RED));
        }
        Button CStn=(Button)findViewById(R.id.button3);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CStn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_RED));
        }

        Button PRtn=(Button)findViewById(R.id.button2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PRtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_RED));
        }


    }
}
