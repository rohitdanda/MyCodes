package com.example.rohitdanda.timer_lecture66;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                Log.i("Handler Timer","Timer was started");
            }
        };

       // handler.post(runnable);

        new CountDownTimer(10000,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("CountDown Timer", String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

                Log.i("CounterDown Timer","was Finished");
            }
        }.start();



    }
}
