package com.example.rohit.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.myListView);

        final ArrayList<String> contacts = new ArrayList<String>();

        contacts.add("rohit");
        contacts.add("sai");
        contacts.add("Kumar");
        contacts.add("Danda");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        ArrayAdapter arr = new ArrayAdapter()


        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = contacts.get(position).toString();
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
