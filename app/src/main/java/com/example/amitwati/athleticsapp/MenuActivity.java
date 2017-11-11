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

        //set the buttons
        ListView lv = (ListView)findViewById(R.id.menu_list);
        ArrayList<Button> a = new ArrayList<>();

        String[] btns = {"האתלטים שלי","תחרויות",
                "מדידות","אימונים","חישוב נקודות"};

        AdapterMenu menu = new AdapterMenu(this,btns,"RED");
        lv.setAdapter(menu);

    }

    //show the popup dialog
    public void dialog(View view) {
        //build the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //inflate the main view for the dialog
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_dialog_layout,null);

        //change the view's params
        ListView lv = (ListView)v.findViewById(R.id.list_view);
        AdapterMenu adapterMenu = new AdapterMenu(this, new String[]{"עמית טואטי","עומרי אבידן","ירדן צ'רי","אביב אדר","דני ברומברג","אדיר אבוחצירה","מייקל ג'קסון","אלן פריד",},"BLUE");
        lv.setAdapter(adapterMenu);

        //set the height of the listview dynamically
        //setListViewHeightBasedOnChildren(lv);

        //set the view to the dialog
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


    }

}
