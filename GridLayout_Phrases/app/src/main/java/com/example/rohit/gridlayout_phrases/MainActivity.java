package com.example.rohit.gridlayout_phrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void musicplay(View view){

        Button button = (Button)(view);

        String buttonname= button.getText().toString();

        Log.i("Test",buttonname);

        if(buttonname.equals("hello")){

            MediaPlayer mediaPlayerhello = MediaPlayer.create(this,R.raw.hello);

            mediaPlayerhello.start();
        }
        else if(buttonname.equals("howareyou")){

            MediaPlayer mediaPlayerhowareyou = MediaPlayer.create(this,R.raw.howareyou);

            mediaPlayerhowareyou.start();
        }
        else if(buttonname.equals("mynameis")){

            MediaPlayer mediaPlayermynameis= MediaPlayer.create(this,R.raw.mynameis);
            mediaPlayermynameis.start();
        }
        else if(buttonname.equals("please")){

            MediaPlayer mediaPlayerplease=MediaPlayer.create(this,R.raw.please);
            mediaPlayerplease.start();
        }
        else if(buttonname.equals("welcome")){

            MediaPlayer mediaPlayerwelcome = MediaPlayer.create(this,R.raw.welcome);
            mediaPlayerwelcome.start();
        }
        else if(buttonname.equals("goodevening")){

            MediaPlayer mediaPlayergoodevening = MediaPlayer.create(this,R.raw.goodevening);

            mediaPlayergoodevening.start();

        }

        else if(buttonname.equals("doyouspeakenglish")){

            MediaPlayer mediaPlayerdoyouspeakenglish = MediaPlayer.create(this,R.raw.doyouspeakenglish);

            mediaPlayerdoyouspeakenglish.start();
        }

        else if(buttonname.equals("ilivein")){

            MediaPlayer mediaPlayerilivein = MediaPlayer.create(this,R.raw.ilivein);

            mediaPlayerilivein.start();
        }




    }
}
