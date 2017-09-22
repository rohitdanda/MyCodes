package com.example.rohitdanda.videotest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            VideoView videoView = (VideoView)findViewById(R.id.VideoViews);

            videoView.setVideoURI(Uri.parse("http://www15.soul-anime.us/watch/detective-conan-episode-682/"));

            MediaController mediaController = new MediaController(this);

            mediaController.setAnchorView(videoView);

            videoView.setMediaController(mediaController);

            videoView.start();
    }
}
