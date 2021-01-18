package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriLima extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewNext , imageViewPrev, imageViewHome, imageViewMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_lima);

        imageViewNext = findViewById(R.id.ivNext);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);

        imageViewNext.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);
        imageViewMateri.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewNext){
            menuNext(imageViewNext);
        } else if (v== imageViewHome ){
            menuUtama(imageViewHome);
        } else if (v == imageViewMateri){
            menuMateri(imageViewMateri);
        }
    }

    public void menuMateri(View v){
        Intent materi = new Intent(this, MateriActivity.class);
        startActivity(materi);
    }
    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void menuNext(View v){
        Intent menu = new Intent(this, MateriLimaD.class);
        startActivity(menu);
    }
}
