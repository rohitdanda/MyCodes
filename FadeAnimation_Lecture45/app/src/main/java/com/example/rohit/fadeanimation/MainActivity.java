package com.example.rohit.fadeanimation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView bartimage = (ImageView)findViewById(R.id.bart);
        bartimage.setScaleX(0.5f);
        bartimage.setScaleY(0.5f);

    }

    public void fade(View view){

        ImageView bartimage = (ImageView)findViewById(R.id.bart);
        //ImageView homerimage =(ImageView)findViewById(R.id.homer);

        bartimage.animate().scaleX(1f).scaleY(1f).setDuration(3000);
       // homerimage.animate().alpha(1f).setDuration(3000);

    }
}
