package com.example.amitwati.athleticsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_competition extends AppCompatActivity {

    int CurrYear=2017;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);
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
                CurrYear+=1;
            }
        });
    }
}
