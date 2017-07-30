package com.example.siddh.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void generateTable(int timesTable) {

        ArrayList<String> numberContent = new ArrayList<String>();
        for(int i = 1; i<=10; ++i) {

            numberContent.add(Integer.toString(i * timesTable));

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numberContent);
        listView.setAdapter(arrayAdapter);

        TextView message = (TextView) findViewById(R.id.message);
        message.setText("Table of " + timesTable);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar number = (SeekBar) findViewById(R.id.number);
        listView = (ListView) findViewById(R.id.listView);

        number.setMax(20);
        number.setProgress(10);

        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;
                if(progress < min) {

                    timesTable = min;
                    number.setProgress(min);


                } else {

                    timesTable = progress;

                }

                generateTable(timesTable);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekbar) {

            }

        });

        int timesTable = 10;

        ArrayList<String> numberContent = new ArrayList<String>();
        for(int i = 1; i<=10; ++i) {

            numberContent.add(Integer.toString(i * timesTable));

        }

        TextView message = (TextView) findViewById(R.id.message);
        message.setText("Table of " + timesTable);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numberContent);
        listView.setAdapter(arrayAdapter);


    }
}
