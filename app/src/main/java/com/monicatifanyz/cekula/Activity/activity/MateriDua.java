package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriDua extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipperr;
    ImageView  imageViewHome, imageViewMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_dua);

        viewFlipperr = findViewById(R.id.viewFlipper);

        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);

        imageViewHome.setOnClickListener(this);
        imageViewMateri.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v== imageViewHome ){
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
}
