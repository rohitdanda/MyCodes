package com.example.rohitdanda.eggtimer;

import android.os.CountDownTimer;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;

    TextView textView;

    CountDownTimer countDownTimer;

    boolean seekbarshown = true;

    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.buttonClick);

        b.setEnabled(true);

        seekBar = (SeekBar) findViewById(R.id.timerSeeker);

        textView = (TextView) findViewById(R.id.displayTimer);

        seekBar.setMax(600);
        seekBar.setProgress(30);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                timer(progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void timer(int secs) {

        int min = (int) secs / 60;
        int sec = secs - min * 60;

        int[] num = {1,2,3,4,5,6,7,8,9};

        String secString = String.valueOf(sec);

        if (secString.equals("0")) {
            secString = "00";
        }
        if(secString.matches("1|2|3|4|5|6|7|8|9")){
            secString="0"+secString;
        }


        textView.setText(String.valueOf(min) + " : " + secString);

    }

    public void onCLickMe(View view) {

        if (seekBar.getProgress() == 0) {

            Toast.makeText(getApplicationContext(), "SeekBar was set to Zero Change it to work", Toast.LENGTH_LONG).show();
        } else {


            if (b.getText().equals("Start") && seekbarshown == true) {


                seekbarshown = false;

                seekBar.setEnabled(false);


                countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {


                    @Override
                    public void onTick(long millisUntilFinished) {

                        timer((int) millisUntilFinished / 1000);


                    }

                    @Override
                    public void onFinish() {

                        textView.setText("0 : 00");
                        b.setEnabled(false);

                        b.setText("Start");
                        seekBar.setProgress(0);

                        seekBar.setEnabled(true);

                    }
                }.start();

                b.setText("Stop");


            } else if (b.getText() == "Stop" && seekbarshown == false) {


                textView.setText("0 : 00");
                seekBar.setProgress(0);
                b.setText("Start");
                seekBar.setEnabled(true);
                seekbarshown = true;

                countDownTimer.cancel();

            }
        }
    }



}
