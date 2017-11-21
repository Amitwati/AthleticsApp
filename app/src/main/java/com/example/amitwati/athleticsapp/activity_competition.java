package com.example.amitwati.athleticsapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class activity_competition extends AppCompatActivity {

    int CurrYear= Calendar.getInstance().get(Calendar.YEAR);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_YELLOW));
        }
        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.measurement_toolbar);
        ((TextView)findViewById(R.id.tb_title)).setText("תחרויות");
        setSupportActionBar(myToolbar);

        //set back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        final ArrayList<String> buttons = new ArrayList<>();
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
        final Context c = this;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = inflater.inflate(R.layout.add_comp_dialog,null);
                Button ABtn=(Button)v.findViewById(R.id.btn_item);
                final EditText Name=(EditText)v.findViewById(R.id.Comp_Text);
                final DatePicker Date = (DatePicker) v.findViewById(R.id.datePicker);
                builder.setView(v);

                //build the alert dialog view
                final AlertDialog dialog = builder.create();

                //remove the titlebar
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                //show the dialog
                dialog.show();

                //set the dismiss btn
                ImageView back_btn = v.findViewById(R.id.back_btn);
                back_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                ABtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int day = Date.getDayOfMonth();
                        int month = Date.getMonth()+1;
                        int year =  Date.getYear();

                        String s = String.valueOf(day)+ "/" + month + "/" + String.valueOf(year);

                        buttons.add(Name.getText().toString()+" "+s);
                        String[] SButtons = new String[buttons.size()];
                        SButtons = buttons.toArray(SButtons);
                        ListView lv = (ListView)findViewById(R.id.ListView);
                        ArrayList<View.OnClickListener> listeners = new ArrayList<>();
                        AdapterMenu adapterMenu = new AdapterMenu(c, SButtons,null,"YELLOW");
                        lv.setAdapter(adapterMenu);
                        dialog.dismiss();
                    }
                });


            }
        });
    }
}