package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriSatu extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper viewFlipperr;
    ImageView imageViewNext , imageViewPrev, imageViewHome, imageViewMateri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_satu);

        viewFlipperr = findViewById(R.id.viewFlipper);
        imageViewNext = findViewById(R.id.ivNext);
        imageViewPrev = findViewById(R.id.ivPrev);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);

        imageViewPrev.setVisibility(View.GONE);
        imageViewNext.setOnClickListener(this);
        imageViewPrev.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);
        imageViewMateri.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == imageViewNext){
            imageViewPrev.setVisibility(View.INVISIBLE);
            viewFlipperr.showNext();
            imageViewPrev.setVisibility(View.VISIBLE);
            imageViewNext.setVisibility(View.INVISIBLE);
        } else if(v == imageViewPrev){
            if (viewFlipperr.getDisplayedChild()==1){
                viewFlipperr.showPrevious();
                imageViewNext.setVisibility(View.VISIBLE);
                imageViewPrev.setVisibility(View.INVISIBLE);

            }
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

}
