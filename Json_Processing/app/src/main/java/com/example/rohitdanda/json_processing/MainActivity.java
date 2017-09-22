package com.example.rohitdanda.json_processing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Jsonprocesing jsonprocesinghere = new Jsonprocesing();

        String resulthere="";

        try {
            jsonprocesinghere.execute("http://api.openweathermap.org/data/2.5/weather?q=Hyderabad,IN&appid=6627ea23a044b3f941afde4c45db4e77").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    public class Jsonprocesing extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {

            String result="";

            URL url;

            HttpURLConnection connection = null;

            try {

                url = new URL(urls[0]);

                connection = (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream in = connection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data!=-1){

                    char c = (char)data;

                    result=result+c;

                    data=reader.read();



                }
                return result;


            }
            catch (Exception e){
                e.printStackTrace();
            }




            return null;


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jobject = new JSONObject(s);

                String weather = jobject.getString("weather");

                JSONArray array = new JSONArray(weather);

                for(int i=0;i<array.length();i++){

                    JSONObject jsonObject = array.getJSONObject(i);

                    String main = jsonObject.getString("main");
                    String description = jsonObject.getString("description");

                    Log.i("Ouput :" ,main+" : "+description);

                }




            } catch (JSONException e) {
                e.printStackTrace();
            }



        }
    }




}
