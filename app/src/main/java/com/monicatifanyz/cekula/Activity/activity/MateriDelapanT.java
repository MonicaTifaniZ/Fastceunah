package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MateriDelapanT extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    ImageView imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_delapan_t);
        youTubePlayerView = findViewById(R.id.activity_main_youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);



        imageViewHome= findViewById(R.id.ivHome);
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "CyUKyN6aOjQ";
                youTubePlayer.cueVideo(videoId, 0);
            }
        });

    }

    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(MateriDelapanT.this, MateriDelapan.class);
        startActivity(i);
    }
}

