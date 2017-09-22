package com.example.rohitdanda.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void toFirst(View view){


        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);



    }

}
