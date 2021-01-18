package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MateriActivity extends AppCompatActivity {
    TextView jdl;
    ImageView imageViewHome, imageViewSatu, imageViewDua, imageViewTiga, imageViewEmpat, imageViewLima,
            imageViewEnam, imageViewTujuh, imageViewDelapan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        jdl = findViewById(R.id.font);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewSatu = findViewById(R.id.ivP1);
        imageViewDua = findViewById(R.id.ivP2);
        imageViewTiga = findViewById(R.id.ivP3);
        imageViewEmpat = findViewById(R.id.ivP4);
        imageViewLima = findViewById(R.id.ivP5);
        imageViewEnam = findViewById(R.id.ivP6);
        imageViewTujuh = findViewById(R.id.ivP7);
        imageViewDelapan = findViewById(R.id.ivP8);


        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });
        imageViewSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 menuSatu(imageViewSatu);
            }
        });
        imageViewDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuDua(imageViewDua);
            }
        });
        imageViewTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuTiga(imageViewTiga);
            }
        });

        imageViewEmpat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuEmpat(imageViewEmpat);
            }
        });
        imageViewLima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLima(imageViewLima);
            }
        });

        imageViewEnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuEnam(imageViewEnam);
            }
        });

        imageViewTujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuTujuh(imageViewTujuh);
            }
        });

        imageViewDelapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuDelapan(imageViewDelapan);
            }
        });
    }

    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void menuSatu(View v){
        Intent satu = new Intent(this, MateriSatu.class);
        startActivity(satu);
    }
    public void menuDua(View v){
        Intent dua = new Intent(this, MateriDua.class);
        startActivity(dua);
    }
    public void menuTiga(View v){
        Intent tiga = new Intent(this, MateriTiga.class);
        startActivity(tiga);
    }
    public void menuEmpat(View v){
        Intent empat = new Intent(this, MateriEmpat.class);
        startActivity(empat);
    }
    public void menuLima(View v){
        Intent lima = new Intent(this, MateriLima.class);
        startActivity(lima);
    }
    public void menuEnam(View v){
        Intent enam = new Intent(this, MateriEnam.class);
        startActivity(enam);
    }
    public void menuTujuh(View v){
        Intent tujuh = new Intent(this, MateriTujuh.class);
        startActivity(tujuh);
    }
    public void menuDelapan(View v){
        Intent delapan = new Intent(this, MateriDelapan.class);
        startActivity(delapan);
    }
}
