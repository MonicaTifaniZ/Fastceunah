package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class Petun extends AppCompatActivity {

    ImageView imageViewNext , imageViewHome, imageViewPetun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petun);

        imageViewNext = findViewById(R.id.ivNext);
        imageViewHome = findViewById(R.id.ivHome);
        imageViewPetun = findViewById(R.id.ivPet);

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

        imageViewPetun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLink(imageViewPetun);
            }
        });
    }
    public void menuLink(View v){
        String url = "https://drive.google.com/drive/folders/1oc3rAMQqPhlnsNH5yf3SMzbotZG1zRqJ?usp=sharing";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }


    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }


    public void menuNext(View v){
        Intent menu = new Intent(this, PetunjukActivity.class);
        startActivity(menu);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Petun.this, MainActivity.class);
        startActivity(i);
    }
}
