package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class Petunjuk2 extends AppCompatActivity {
    ImageView  imageViewPrev, imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk2);

        imageViewPrev = findViewById(R.id.ivPrev);
        imageViewHome = findViewById(R.id.ivHome);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
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
    public void menuPrev(View v){
        Intent menu = new Intent(this, PetunjukActivity.class);
        startActivity(menu);
    }

}
