package com.example.amitwati.athleticsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Amitwati on 11/11/2017.
 */

public class AdapterMenu extends BaseAdapter {
    ArrayList<String> buttons;
    Context context;
    LayoutInflater inflater;
    String color;

    public AdapterMenu(Context c,String[] b,String col) {
        context = c;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        buttons = new ArrayList<>(Arrays.asList(b));
        color = col;
    }

    @Override
    public int getCount() {
        return buttons.size();
    }

    @Override
    public Object getItem(int i) {
        return buttons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") final View v = inflater.inflate(R.layout.menu_list_item,null);
        Button b =  v.findViewById(R.id.btn_item);
        b.setText(buttons.get(i));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switch (color) {

                case "RED":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_RED));
                    b.setTextColor(context.getResources().getColor(R.color.colorBright_RED));
                    break;

                case "BLUE":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_BLUE));
                    b.setTextColor(context.getResources().getColor(R.color.colorBright_BLUE));
                    break;

                case "YELLOW":
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_YELLOW));
                    b.setTextColor(context.getResources().getColor(R.color.colorBright_YELLOW));
                    break;

                default:
                    b.setBackgroundTintList(context.getResources().getColorStateList(R.color.colorPrimary_GREEN));
                    b.setTextColor(context.getResources().getColor(R.color.colorBright_GREEN));
                    break;
            }
        }

        return v;
    }
}
