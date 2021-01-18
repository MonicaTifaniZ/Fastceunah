package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.Activity.model.SoalPilihanGanda;
import com.monicatifanyz.cekula.R;

public class ReviewActivity extends AppCompatActivity {

    //membuat objek dari kelas SoalPilihanGanda.java
    SoalPilihanGanda soalPG = new SoalPilihanGanda();

    ImageView imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        imageViewHome = findViewById(R.id.ivHome);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

    }

    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(ReviewActivity.this, MainActivity.class);
        startActivity(i);
    }
}



