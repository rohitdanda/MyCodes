package com.example.rohitdanda.guessthecelebrity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    DownloadPageString getStringdata = new DownloadPageString();




    ImageView imageViewhere ;

    Button Abutton,Bbutton,Cbutton,Dbutton ;
     int correctanswer;



    ArrayList<String> celebrityUrl = new ArrayList<>();
    ArrayList<String> celebrityname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String resulthere;

        Pattern p;

        Matcher m;




        imageViewhere = (ImageView) findViewById(R.id.imageview);

        Abutton = (Button) findViewById(R.id.button1);
        Bbutton = (Button)findViewById(R.id.button2);
        Cbutton = (Button)findViewById(R.id.button3);
        Dbutton = (Button)findViewById(R.id.button4);



        try {
            resulthere=getStringdata.execute("http://www.posh24.se/kandisar").get();

            Log.i("Output here:" , resulthere);

            String afterSplit[] = resulthere.split("<div class=\"sidebarContainer");

            p = Pattern.compile("img src=\"(.*?)\"");

             m = p.matcher(afterSplit[0]);

            int n = 1 ;

            while(m.find()){

                System.out.println(n+" "+m.group(1));

                celebrityUrl.add(m.group(1));

                n++;
            }

            p = Pattern.compile("alt=\"(.*?)\"");

             m = p.matcher(afterSplit[0]);

            int n1 = 1 ;

            while(m.find()){

                System.out.println(n1+" "+m.group(1));

                celebrityname.add(m.group(1));

                n1++;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        setGetImage();


    }

    public void onclicker(View view){

        String getname = view.getTag().toString();

        if(getname.equals(celebrityname.get(correctanswer)))
        {

            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

        }
        else
        {

            Toast.makeText(getApplicationContext(),"Wrong answer"+celebrityname.get(correctanswer),Toast.LENGTH_SHORT).show();
        }

        setGetImage();

    }

    public void setGetImage(){

        Random random = new Random();
        int randomnumber = random.nextInt(celebrityname.size());
        correctanswer=randomnumber;
        DownloadImages getImage = new DownloadImages();
        Bitmap celebrityimages;



        try {
            celebrityimages = getImage.execute(celebrityUrl.get(randomnumber)).get();

            imageViewhere.setImageBitmap(celebrityimages);

            ArrayList<String> optionnames= new ArrayList<>();

            if(randomnumber>95) {

                optionnames .add(celebrityname.get(randomnumber));
                optionnames.add(celebrityname.get(8));
                optionnames.add(celebrityname.get(12));
                optionnames.add(celebrityname.get(20));
            }
            else {

                optionnames .add(celebrityname.get(randomnumber));
                optionnames.add(celebrityname.get(randomnumber+1));
                optionnames.add(celebrityname.get(randomnumber+2));
                optionnames.add(celebrityname.get(randomnumber+3));

            }

            Collections.shuffle(optionnames);



            Abutton.setText(optionnames.get(0));
            Abutton.setTag(optionnames.get(0));
            Bbutton.setText(optionnames.get(1));
            Bbutton.setTag(optionnames.get(1));
            Cbutton.setText(optionnames.get(2));
            Cbutton.setTag(optionnames.get(2));
            Dbutton.setText(optionnames.get(3));
            Dbutton.setTag(optionnames.get(3));



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    public class DownloadPageString extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url ;
            HttpURLConnection connection=null;

            try {
                url = new URL(urls[0]);

                connection = (HttpURLConnection)url.openConnection();

                InputStream in = connection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while(data!=-1){

                    char c = (char)data;

                    result=result+c;

                    data=reader.read();
                }


            }
            catch (Exception e){
                e.printStackTrace();
            }

            return result;

        }
    }

    public class DownloadImages extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            Bitmap returnimage;

            try{

                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream in = connection.getInputStream();

                returnimage = BitmapFactory.decodeStream(in);

                return returnimage;

            }
            catch (Exception e){
                e.printStackTrace();
            }

            return null;

        }
    }
}
