package com.example.rohit.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBarTimeTable = (SeekBar)findViewById(R.id.seekBar);

        seekBarTimeTable.setProgress(1);
        seekBarTimeTable.setMax(50);

        seekBarTimeTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min=1;
                int tabletime;

                if(progress < min){
                    seekBarTimeTable.setProgress(min);
                    tabletime=min;
                }
                else {
                    tabletime=progress;
                }
                Log.i("SeekValue",Integer.toString(tabletime));

                generateTable(tabletime);





            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTable(1);




    }
    public void generateTable(int number){


         listView= (ListView)findViewById(R.id.timeTableListView);

        final ArrayList<String> timetablenumber = new ArrayList<>();

        for(int i=1;i<=10;i++){

            timetablenumber.add(number +" X "+i+" = "+Integer.toString( i*number));

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,timetablenumber);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),timetablenumber.get(position),Toast.LENGTH_LONG).show();
            }
        });


    }
}
