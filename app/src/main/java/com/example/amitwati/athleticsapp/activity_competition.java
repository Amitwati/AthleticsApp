package com.example.amitwati.athleticsapp;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class activity_competition extends AppCompatActivity {

    int CurrYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_YELLOW));
        }
        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.competition_toolbar);
        myToolbar.setTitle("תחרויות");
        setSupportActionBar(myToolbar);

        //set back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        CurrYear = Calendar.getInstance().get(Calendar.YEAR);


        String[] buttons = new String[]{"שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","שיאים אישיים","תוצאות תחרויות","תוצאות מדידות"};
        ListView lv = (ListView)findViewById(R.id.ListView);
        ArrayList<View.OnClickListener> listeners = new ArrayList<>();
        AdapterMenu adapterMenu = new AdapterMenu(this,buttons,null,"YELLOW");
        lv.setAdapter(adapterMenu);

        final TextView Year=(TextView)findViewById(R.id.YearView);
        Year.setText(Integer.toString(CurrYear));
        Button LeftButton=(Button)findViewById(R.id.Lbutton);
        LeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Year.setText(Integer.toString(CurrYear-1));
                CurrYear-=1;
            }
        });
        Button RightButton=(Button)findViewById(R.id.Rbutton);
        RightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Year.setText(Integer.toString(CurrYear+1));
                CurrYear++;
            }
        });
    }
}
