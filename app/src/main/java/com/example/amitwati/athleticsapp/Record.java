package com.example.amitwati.athleticsapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by amitwati on 20/11/17.
 */

public class Record {
    private static LayoutInflater inflater;
    public View record_view;

    public Record(Context context, String title, String record, String COLOR) {
        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        record_view =  inflater.inflate(R.layout.records_list_item,null);

        TextView tx1 = record_view.findViewById(R.id.title_rec);
        TextView tx2 = record_view.findViewById(R.id.value_rec);

        tx1.setText(title);
        tx2.setText(record);

        RelativeLayout layout = (RelativeLayout)record_view.findViewById(R.id.record_list_layout);

        switch (COLOR) {
            case "YELLOW":
                tx1.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_YELLOW));
                tx2.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_YELLOW));
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    layout.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.colorPrimary_YELLOW));
                }
                else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
                    layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary_YELLOW));
                }
                break;

            case "BLUE":
                tx1.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_BLUE));
                tx2.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_BLUE));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    layout.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.colorPrimary_BLUE));
                }
                else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
                    layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary_BLUE));
                }
                break;

            case "RED":
                tx1.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_RED));
                tx2.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_RED));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    layout.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.colorPrimary_RED));
                }
                else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
                    layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary_RED));
                }
                break;

            case "GREEN":
                tx1.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_GREEN));
                tx2.setTextColor(ContextCompat.getColorStateList(context, R.color.colorBright_GREEN));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    layout.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.colorPrimary_GREEN));
                }
                else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
                    layout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary_GREEN));
                }
                break;

        }

    }
}
