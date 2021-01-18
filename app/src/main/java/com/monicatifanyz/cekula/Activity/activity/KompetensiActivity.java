package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class KompetensiActivity extends AppCompatActivity {
LinearLayout  lnViewSatu, lnViewDua, lnViewTiga;
ImageView imageViewHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetensi);

        imageViewHome = findViewById(R.id.ivHome);
        lnViewSatu = findViewById(R.id.line1);
        lnViewDua = findViewById(R.id.line2);
        lnViewTiga = findViewById(R.id.line3);


        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });
        lnViewSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuSatu(lnViewSatu);
            }
        });
        lnViewDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuDua(lnViewDua);
            }
        });

        lnViewTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuTiga(lnViewTiga);
            }
        });

    }

    public void menuUtama(View v){
        Intent menuUtama = new Intent(this, MainActivity.class);
        startActivity(menuUtama);
    }

    public void menuSatu(View v){
        Intent satu = new Intent(this, KIActivity.class);
        startActivity(satu);
    }

    public void  menuDua(View v){
        Intent dua = new Intent(this, KDActivity.class);
        startActivity(dua);
    }

    public void  menuTiga(View v){
        Intent tiga = new Intent(this, TPActivity.class);
        startActivity(tiga);
    }
}
