package com.example.rohitdanda.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;



    public void downloadImage(View view){

        Log.i("Output","hello");

        DownloadingImages images = new DownloadingImages();

        try {
            Bitmap getImage = images.execute("https://vignette4.wikia.nocookie.net/simpsons/images/a/aa/Bart_simpson.png/revision/latest?cb=20130815081755").get();

            imageView.setImageBitmap(getImage);


        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public class DownloadingImages extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {



            try
            {

                 URL url = new URL(urls[0]);

                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                connection.connect();

                InputStream in = connection.getInputStream();

               Bitmap downimage = BitmapFactory.decodeStream(in);

                return downimage;


            }
            catch (Exception e){

                e.printStackTrace();
            }


            return null;




        }
    }
}
