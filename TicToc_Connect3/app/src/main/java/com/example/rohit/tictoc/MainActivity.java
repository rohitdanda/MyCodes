package com.example.rohit.tictoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int turn = 1;

    int gameState[]={2,2,2,2,2,2,2,2,2};

    String Winner;

    int[][] gamewinningstate ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{3,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dropin(View view){
        ImageView counter = (ImageView)view;



        int counterposition = Integer.parseInt(counter.getTag().toString());

        if(gameState[counterposition]==2) {

            gameState[counterposition]=turn;

            counter.setTranslationX(-1000f);

            if (turn == 1) {
                counter.setImageResource(R.drawable.yellow);

                counter.animate().translationXBy(1000f).setDuration(300);

                turn--;
            } else if (turn == 0) {
                counter.setImageResource(R.drawable.red);

                counter.animate().translationXBy(1000f).setDuration(300);

                turn++;
            }

            for(int[] gamewinner :gamewinningstate){

                if(gameState[gamewinner[0]]==gameState[gamewinner[1]]&& gameState[gamewinner[1]]==gameState[gamewinner[2]] && gameState[gamewinner[0]]!=2 ){


                    if(gameState[gamewinner[0]]==0){
                        Winner="Yellow";
                        for(int x: gameState){
                            x=-1;
                        }
                    }

                    else {
                        Winner="Red";
                    }

                    TextView winnertext = (TextView)findViewById(R.id.winnertext);

                    winnertext.setText(Winner+" Was Winner");

                    LinearLayout winnerlayout = (LinearLayout)findViewById(R.id.winnerlayout);

                    winnerlayout.setVisibility(View.VISIBLE);



                }

            }





        }




    }
}
