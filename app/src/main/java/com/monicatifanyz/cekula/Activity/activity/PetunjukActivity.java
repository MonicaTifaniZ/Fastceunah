package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class PetunjukActivity extends AppCompatActivity  {

    ImageView imageViewNext , imageViewPrev, imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);

        imageViewNext = findViewById(R.id.ivNext);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewPrev = findViewById(R.id.ivPrev);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });
        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuNext(imageViewNext);
            }
        });

        imageViewPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuPrev(imageViewPrev);
            }
        });
    }
    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }


    public void menuNext(View v){
        Intent menu = new Intent(this, Petunjuk2.class);
        startActivity(menu);
    }

    public void menuPrev(View v){
        Intent menu = new Intent(this, Petun.class);
        startActivity(menu);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(PetunjukActivity.this, MainActivity.class);
        startActivity(i);
    }

//    @Override
//    public void onClick(View v) {
//        if (v == imageViewNext){
//            menuNext(imageViewNext);
//        } else if (v == imageViewPrev){
//            menuPrev(imageViewPrev);
//        } else if (v == imageViewHome){
//            menuUtama(imageViewHome);
//        }
//    }
}

