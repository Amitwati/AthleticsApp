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
import android.widget.Toast;

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
                final String[] names = new String[]{"עומרי אבידן", "עמית טואטי", "ירדן צ'רי", "סקאזי", "אילון מתנה"};
                ArrayList<View.OnClickListener> listeners = new ArrayList<>();
                final Context c = this;
                for(int i=0;i<names.length;i++){
                    listeners.add(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final String s = ((Button)view).getText().toString();

                            String[] titles = new String[]{"שיאים אישיים","תוצאות תחרויות","תוצאות מדידות"};
                            ArrayList<View.OnClickListener> l = new ArrayList<>();
                            for(String i:titles)
                                l.add(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MenuActivity.this, "here im going to start new intent\nname is "+s+"\nand i have context :P",
                                                Toast.LENGTH_LONG).show();
                                    }
                                });

                            Helper.ShowDialog(c,titles,l,s,"GREEN");
                        }
                    });
                }

                Helper.ShowDialog(this, names,listeners,
                        ((Button) view).getText().toString(), "BLUE");
                break;

        }
    }
}
