package com.example.amitwati.athleticsapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by omri on 11/20/17.
 */

public class AthletesMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_BLUE));
        }
        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.main_toolbar);
        myToolbar.setTitle("אתלטי הנגב");
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary_BLUE));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ((RelativeLayout)findViewById(R.id.Relative)).setBackgroundColor(ContextCompat.getColor(this,R.color.colorBright_BLUE));
        Button Abtn=(Button)findViewById(R.id.my_athletes);
        Abtn.setVisibility(View.GONE);
        Button Contestbtn=(Button)findViewById(R.id.competition);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        Contestbtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_BLUE));
        }
        Contestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toContestmenu(view);
            }
        });
        Button Measurementsbtn=(Button)findViewById(R.id.measurements);
        Measurementsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMeasurementmenu(view);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Measurementsbtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_BLUE));
        }
        Button Trainingsbtn=(Button)findViewById(R.id.trainings);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Trainingsbtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_BLUE));
        }
        Button Calc_pointsbtn=(Button)findViewById(R.id.calc_points);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Calc_pointsbtn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorPrimary_BLUE));
        }

    }

    public void toContestmenu(View view) {
        Intent i = new Intent(this,AthletesContestActivity.class);
        startActivity(i);
    }
    public void toMeasurementmenu(View view) {
        Intent i = new Intent(this,AthletesMeasurmentActivity.class);
        startActivity(i);
    }
    public void toTrainingmenu(View view) {
        Intent i = new Intent(this,CoachMenu.class);
        startActivity(i);
    }
    public void toCalcmenu(View view) {
        Intent i = new Intent(this,CoachMenu.class);
        startActivity(i);
    }
}
