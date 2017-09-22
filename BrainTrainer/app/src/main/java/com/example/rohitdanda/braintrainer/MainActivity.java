package com.example.rohitdanda.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,reset;
    GridLayout gridLayout;
    List<Integer> answers;
    TextView textView,correct,wrong,timer,winnerMessage;
    int a,b;



    int correctvalue;
    int wrongvalue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        one = (Button)findViewById(R.id.answerA);
        two = (Button)findViewById(R.id.answerB);
        three = (Button)findViewById(R.id.answerC);
        four = (Button)findViewById(R.id.answerD);
        reset = (Button)findViewById(R.id.reset);

       one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);

        correct = (TextView)findViewById(R.id.correct);
        wrong = (TextView)findViewById(R.id.wrong);
        timer = (TextView)findViewById(R.id.timer);
        winnerMessage = (TextView)findViewById(R.id.winnerMessage);

        correct.setText("Correct :");
        wrong.setText("Wrong :");

        reset.setEnabled(false);

        design();

        timerMethod();





    }
    public void onSelect(View view){

         String tap = String.valueOf(view.getTag());

        Log.i("Enterd",tap);
        int pressedAnswer;

        if(tap.matches("one")){

            pressedAnswer=Integer.parseInt(one.getText().toString());

            Log.i("Enterd",String.valueOf(pressedAnswer));
            updateResult(pressedAnswer);
        }
        if(tap.matches("two")){

            pressedAnswer=Integer.parseInt(two.getText().toString());

            Log.i("Enterd",String.valueOf(pressedAnswer));
            updateResult(pressedAnswer);
        }
        if(tap.matches("three")){

            pressedAnswer=Integer.parseInt(three.getText().toString());

            Log.i("Enterd",String.valueOf(pressedAnswer));
            updateResult(pressedAnswer);
        }
        if(tap.matches("four")){

            pressedAnswer=Integer.parseInt(four.getText().toString());

            Log.i("Enterd",String.valueOf(pressedAnswer));
            updateResult(pressedAnswer);
        }
        if(tap.matches("reset"))
        {


            correctvalue=0;
            one.setEnabled(true);
            two.setEnabled(true);
            three.setEnabled(true);
            four.setEnabled(true);
            wrongvalue=0;
            correct.setText("Correct :");
            wrong.setText("Wrong :");
            winnerMessage.setText("");
            timerMethod();
            design();



        }



        design();
    }
    public void design(){

        textView= (TextView)findViewById(R.id.question);
        a = (int)(Math.random()*(50-1));

        b = (int)(Math.random()*(50-1));


        int answer = a+b;

        int guess1=(int)(Math.random()*(50-1));
        int guess2=(int)(Math.random()*(50-1));
        int guess3=(int)(Math.random()*(50-1));

        textView.setText(a +"+"+b);

        answers= new ArrayList<>();

        answers.add(answer);
        answers.add(guess1);
        answers.add(guess2);
        answers.add(guess3);

        Collections.shuffle(answers);



        one.setText(String.valueOf(answers.get(0)));
        two.setText(String.valueOf(answers.get(1)));
        three.setText(String.valueOf(answers.get(2)));
        four.setText(String.valueOf(answers.get(3)));
    }
    public void updateResult(int pressnumber){
        if(pressnumber==a+b){
            correctvalue=correctvalue+1;

            correct.setText("Correct : "+correctvalue);
        }
        else {

            wrongvalue=wrongvalue+1;

            wrong.setText("Wrong : "+wrongvalue);
        }
    }
    public void timerMethod(){
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {

                timer.setText("0");
                one.setEnabled(false);
                two.setEnabled(false);
                three.setEnabled(false);
                four.setEnabled(false);
                reset.setEnabled(true);



                if(correctvalue>wrongvalue){

                    winnerMessage.setText("   Your the Winner ");

                }
                else if(wrongvalue>correctvalue){

                    winnerMessage.setText("You Lose the Game");
                }
                else if(correctvalue==wrongvalue){

                    winnerMessage.setText("Your Game was Tie");
                }



            }
        }.start();
    }
}
