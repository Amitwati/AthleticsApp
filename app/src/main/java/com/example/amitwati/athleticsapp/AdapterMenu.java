package com.example.amitwati.athleticsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Amitwati on 11/11/2017.
 */

public class AdapterMenu extends BaseAdapter {
    ArrayList<String> buttons_titles;
    ArrayList<View.OnClickListener> buttons_listeners;
    Context context;
    LayoutInflater inflater;
    String color;

    public AdapterMenu(Context c, String[] btns, ArrayList<View.OnClickListener> listener_list , String col) {
        context = c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        color = col;
        buttons_titles = new ArrayList<>(Arrays.asList(btns));
        buttons_listeners = listener_list;
    }

    @Override
    public int getCount() {
        return buttons_titles.size();
    }

    @Override
    public Object getItem(int i) {
        return buttons_titles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") final View v = inflater.inflate(R.layout.menu_list_item,null);
        Button b =  v.findViewById(R.id.btn_item);
        b.setText(buttons_titles.get(i));
        if(buttons_listeners!=null)
            b.setOnClickListener(buttons_listeners.get(i));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switch (color) {

                case "RED":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_RED));
                    break;

                case "BLUE":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_BLUE));
                    break;

                case "YELLOW":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_YELLOW));
                    break;

                default:
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_GREEN));
                    break;
            }
        }


        return v;
    }
}
