package com.example.lotterypool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lotteryListView;

    private String[] lotteryOptions = new String[]{"威力彩","大樂透"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        setAdapter();
        setOnClickListerner();
    }

    private void initWidgets() {
        lotteryListView = (ListView) findViewById(R.id.optionsListView);
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lotteryOptions);
        lotteryListView.setAdapter(adapter);
    }

    private void setOnClickListerner() {
        lotteryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lotteryListView.getItemAtPosition(position);
                Intent selectionIntent = new Intent(getApplicationContext(), numericalSelection.class);
                startActivity(selectionIntent);
            }
        });
    }

}