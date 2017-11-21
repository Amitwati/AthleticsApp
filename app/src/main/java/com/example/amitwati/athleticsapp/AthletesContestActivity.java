package com.example.amitwati.athleticsapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by omri on 11/20/17.
 */

public class AthletesContestActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.athletes_contest_measurements);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_GREEN));
        }
        Toolbar myToolbar = findViewById(R.id.main_toolbar);
        myToolbar.setTitle("תחרויות");
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary_GREEN));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

//        View.OnClickListener clickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };

        b1.setOnClickListener(this);

        b2.setOnClickListener(this);

        b3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                Helper.ShowDialog(this,new String[]{"אליפות חורף","אליפות הנגב","אליפות הקיץ","אליפות האלופים"},null, "בחר תחרות","RED");
                break;

            case R.id.button2:

                break;

            default:
                Helper.ShowDialog(this,Helper.AmitList,null, "בחר מקצוע","RED");
                break;
        }
    }
}
