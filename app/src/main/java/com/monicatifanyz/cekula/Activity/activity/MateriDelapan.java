package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class MateriDelapan extends AppCompatActivity implements View.OnClickListener{

    ImageView imageViewHome, imageViewMateri;
    LinearLayout ln1, ln2, ln3, ln4, ln5, ln6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_delapan);


        imageViewHome = findViewById(R.id.ivHome);
        imageViewMateri = findViewById(R.id.ivMateri);
        ln1 = findViewById(R.id.line1);
        ln2 = findViewById(R.id.line2);
        ln3 = findViewById(R.id.line3);
        ln4 = findViewById(R.id.line4);
        ln5 = findViewById(R.id.line5);
        ln6 = findViewById(R.id.line6);


        imageViewHome.setOnClickListener(this);
        imageViewMateri.setOnClickListener(this);
        ln1.setOnClickListener(this);
        ln2.setOnClickListener(this);
        ln3.setOnClickListener(this);
        ln4.setOnClickListener(this);
        ln5.setOnClickListener(this);
        ln6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== imageViewHome ){
            menuUtama(imageViewHome);
        } else if (v == imageViewMateri){
            menuMateri(imageViewMateri);
        } else if (v == ln1){
            vidSatu(ln1);
        } else if (v == ln2){
            vidDua(ln2);
        } else if (v == ln3){
            vidTiga(ln3);
        } else if (v == ln4){
            vidEmpat(ln4);
        } else if (v == ln5){
            vidLima(ln5);
        } else if (v == ln6){
            vidEnam(ln6);
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

    public void vidSatu(View v){
        Intent vidS = new Intent(this, MateriDelapanS.class);
        startActivity(vidS);
    }

    public void vidDua(View v){
        Intent vidS = new Intent(this, MateriDelapanD.class);
        startActivity(vidS);
    }
    public void vidTiga(View v){
        Intent vidS = new Intent(this, MateriDelapanT.class);
        startActivity(vidS);
    }
    public void vidEmpat(View v){
        Intent vidS = new Intent(this, MateriDelapanEm.class);
        startActivity(vidS);
    }
    public void vidLima(View v){
        Intent vidS = new Intent(this, MateriDelapanL.class);
        startActivity(vidS);
    }

    public void vidEnam(View v){
        Intent vidS = new Intent(this, MateriDelapanE.class);
        startActivity(vidS);
    }
}
