package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriTigaD extends AppCompatActivity {

    ImageView imageViewNext , imageViewPrev, imageViewHome, imageViewMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_tiga_d);

        imageViewNext = findViewById(R.id.ivNext);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);
        imageViewPrev = findViewById(R.id.ivPrev);

        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuMateriTigaT(imageViewNext);
            }
        });

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });
        imageViewMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuMateri(imageViewMateri);
            }
        });

        imageViewPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuMateriTigaD(imageViewPrev);
            }
        });


    }

    public void menuMateriTigaD(View v){
        Intent i = new Intent(this, MateriTiga.class);
        startActivity(i);
    }
    public void menuMateriTigaT(View v){
        Intent i = new Intent(this, MateriTigaT.class);
        startActivity(i);
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
