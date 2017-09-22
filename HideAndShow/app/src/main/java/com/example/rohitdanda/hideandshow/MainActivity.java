package com.example.rohitdanda.hideandshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textDisplay);


    }
    public void onClickButton(View view){

        String tagname = view.getTag().toString();

        if(tagname.equals("hide")){

            textView.setVisibility(View.INVISIBLE);

        }
        else if(tagname.equals("show")){

            textView.setVisibility(View.VISIBLE);
        }


    }
}
