package com.example.amitwati.athleticsapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_RED));
        }
        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.main_toolbar);
        myToolbar.setTitle("אתלטי הנגב");
        setSupportActionBar(myToolbar);

        //set back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void open_dialog(View view) {
        switch(view.getId()) {
            case R.id.my_athletes:
                Helper.ShowDialog(this, new String[]{"עומרי אבידן", "עמית טואטי", "ירדן צ'רי", "סקאזי", "אילון מתנה"},
                        ((Button) view).getText().toString(), "BLUE");
                break;
            case R.id.competition:
                Helper.ShowDialog(this, new String[]{"עומרי אבידן הומו"},
                        ((Button) view).getText().toString(), "RED");
                break;
            case R.id.measurements:
                Helper.ShowDialog(this, new String[]{"ירדן צ'רי הומו"},
                        ((Button) view).getText().toString(), "GREEN");
                break;
            case R.id.trainings:
                Helper.ShowDialog(this, new String[]{"אילון מתנה גיי"},
                        ((Button) view).getText().toString(), "GREEN");
                break;
            case R.id.calc_points:
                Helper.ShowDialog(this, new String[]{"עמית הגבר :)"},
                        ((Button) view).getText().toString(), "YELLOW");
                break;

        }
    }
}
