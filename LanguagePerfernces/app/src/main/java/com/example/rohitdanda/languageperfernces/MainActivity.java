package com.example.rohitdanda.languageperfernces;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView textViewhere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewhere = (TextView)findViewById(R.id.textview);



         sharedPreferences = this.getSharedPreferences("com.example.rohitdanda.languageperfernces", Context.MODE_PRIVATE);

        String languageget = sharedPreferences.getString("language","");

        textViewhere.setText(languageget);

        new AlertDialog.Builder(this).
                setIcon(android.R.drawable.ic_menu_edit).
                setTitle("Change Language ?").
                setMessage("Sure to change Language ?").
                setPositiveButton("English", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        sharedPreferences.edit().putString("language","English").commit();

                        textViewhere.setText("English");


                    }
                }).setNegativeButton("Telugu ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putString("language","Telugu").commit();
                textViewhere.setText("Telugu");
            }
        }).show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_here,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        int selected = item.getItemId();

        if(selected==R.id.english){

            sharedPreferences.edit().putString("language","English").commit();

            textViewhere.setText("English");

            return true;
        }

        if(selected == R.id.telugu){

            sharedPreferences.edit().putString("language","Telugu").commit();
            textViewhere.setText("Telugu");

        }

        return false;

    }
}
