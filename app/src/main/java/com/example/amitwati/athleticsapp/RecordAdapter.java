package com.example.amitwati.athleticsapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by amitwati on 20/11/17.
 */

public class RecordAdapter extends BaseAdapter {
    ArrayList<Record> records;

    public RecordAdapter(ArrayList<Record> records) {
        this.records = records;
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int i) {
        return records.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return records.get(i).record_view;
    }
}
