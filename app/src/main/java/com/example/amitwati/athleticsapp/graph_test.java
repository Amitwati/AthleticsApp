package com.example.amitwati.athleticsapp;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class graph_test extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    static String[] month = {"January","February",
            "March","April","May","June","July","August",
            "September","October","November","December"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_test_layout);

        //bind view to object
        chart = (BarChart) findViewById(R.id.chart);

        //value list
        BARENTRY = new ArrayList<>();

        //title list
        BarEntryLabels = new ArrayList<String>();

        for(int i=0;i<month.length;i++){
            //add value to the column
            BARENTRY.add(new BarEntry((new Random()).nextFloat() + (new Random()).nextInt(100), i));

            //add title to the column
            BarEntryLabels.add(month[i]);
        }

        //config the visual of the data set
        Bardataset = new BarDataSet(BARENTRY, "scores");
        Bardataset.setValueTextSize(10f);
        Bardataset.setColors(ColorTemplate.JOYFUL_COLORS);
        Bardataset.setStackLabels(month);
        BARDATA = new BarData(BarEntryLabels, Bardataset);

        //set the data to the chart
        chart.setData(BARDATA);
        chart.animateY(3000);

    }





}
