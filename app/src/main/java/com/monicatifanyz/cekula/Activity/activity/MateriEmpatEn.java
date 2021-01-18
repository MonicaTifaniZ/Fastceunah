package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriEmpatEn extends AppCompatActivity implements View.OnClickListener {

    ImageView imageViewNext , imageViewPrev, imageViewHome, imageViewMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_empat_en);

        imageViewPrev = findViewById(R.id.ivPrev);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);

        imageViewPrev.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);
        imageViewMateri.setOnClickListener(this);

    }

    public void menuMateri(View v){
        Intent materi = new Intent(this, MateriActivity.class);
        startActivity(materi);
    }
    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

//    public void menuNext(View v){
//        Intent menu = new Intent(this, MateriEmpatL.class);
//        startActivity(menu);
//    }

    public void menuPrev(View v){
        Intent menu = new Intent(this, MateriEmpatL.class);
        startActivity(menu);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewPrev){
            menuPrev(imageViewPrev);
        }
        else if (v== imageViewHome ){
            menuUtama(imageViewHome);
        } else if (v == imageViewMateri){
            menuMateri(imageViewMateri);
        }
    }
}
