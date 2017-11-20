package com.example.amitwati.athleticsapp;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            (getWindow()).setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimaryDark_YELLOW));
        }
        //set the toolbar
        Toolbar myToolbar = findViewById(R.id.list_layout_tb);
        setSupportActionBar(myToolbar);

        //set back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //get the extras from the calling intent
        Bundle extra = getIntent().getExtras();
        assert extra != null;

        //set the title
        String title = extra.getString("TITLE");
        ((TextView)findViewById(R.id.tb_title)).setText(title);

        ListView lv = findViewById(R.id.list_records);

        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(this,"sss","ssss","YELLOW"));
        records.add(new Record(this,"sss","ssss","GREEN"));
        records.add(new Record(this,"sss","ssss","BLUE"));
        records.add(new Record(this,"sss","ssss","RED"));
        records.add(new Record(this,"sss","ssss","YELLOW"));
        records.add(new Record(this,"sss","ssss","GREEN"));
        records.add(new Record(this,"sss","ssss","BLUE"));
        records.add(new Record(this,"sss","ssss","RED"));
        records.add(new Record(this,"sss","ssss","YELLOW"));
        records.add(new Record(this,"sss","ssss","GREEN"));
        records.add(new Record(this,"sss","ssss","BLUE"));
        records.add(new Record(this,"sss","ssss","RED"));

        RecordAdapter adapter = new RecordAdapter(records);
        lv.setAdapter(adapter);



    }
}
