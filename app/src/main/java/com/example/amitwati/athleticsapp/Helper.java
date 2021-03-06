package com.example.amitwati.athleticsapp;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by amitwati on 13/11/17.
 */

public class Helper {
    static String[] AmitList = new String[]{"קפיצה למרחק","קפיצה לגובה","ריצה 60 מטר","ריצה 100 מטר","ריצה 400 מטר","ריצה 600 מטר","כדור ברזל"};

    static void ShowDialog(Context context, String[] buttons, ArrayList<View.OnClickListener> listeners, String title, String color){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //inflate the main view for the dialog
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_dialog_layout,null);

        //change the view's params
        ListView lv = (ListView)v.findViewById(R.id.list_view);
        AdapterMenu adapterMenu = new AdapterMenu(context,buttons,listeners,color);
        lv.setAdapter(adapterMenu);
        //title
        TextView _title = v.findViewById(R.id.dialog_title);
        _title.setText(title);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switch (color) {

                case "RED":
                    _title.setTextColor(context.getResources().getColorStateList(R.color.colorPrimary_RED));
                    (v.findViewById(R.id.main_layout)).setBackgroundColor(context.getResources().getColor(R.color.colorBright_RED));
                    ((ImageView)v.findViewById(R.id.back_btn)).setImageTintList(context.getResources().getColorStateList(R.color.colorPrimary_RED));
                    break;

                case "BLUE":
                    _title.setTextColor(context.getResources().getColorStateList(R.color.colorPrimary_BLUE));
                    (v.findViewById(R.id.main_layout)).setBackgroundColor(context.getResources().getColor(R.color.colorBright_BLUE));
                    ((ImageView)v.findViewById(R.id.back_btn)).setImageTintList(context.getResources().getColorStateList(R.color.colorPrimary_BLUE));
                    break;

                case "YELLOW":
                    _title.setTextColor(context.getResources().getColorStateList(R.color.colorPrimary_YELLOW));
                    (v.findViewById(R.id.main_layout)).setBackgroundColor(context.getResources().getColor(R.color.colorBright_YELLOW));
                    ((ImageView)v.findViewById(R.id.back_btn)).setImageTintList(context.getResources().getColorStateList(R.color.colorPrimary_YELLOW));
                    break;

                default:
                    _title.setTextColor(context.getResources().getColorStateList(R.color.colorPrimary_GREEN));
                    (v.findViewById(R.id.main_layout)).setBackgroundColor(context.getResources().getColor(R.color.colorBright_GREEN));
                    ((ImageView)v.findViewById(R.id.back_btn)).setImageTintList(context.getResources().getColorStateList(R.color.colorPrimary_GREEN));
                    break;
            }
        }


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
