package com.monicatifanyz.cekula.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.cekula.Activity.activity.KompetensiActivity;
import com.monicatifanyz.cekula.Activity.activity.LoginActivity;
import com.monicatifanyz.cekula.Activity.activity.MateriActivity;
import com.monicatifanyz.cekula.Activity.activity.PengembangActivity;
import com.monicatifanyz.cekula.Activity.activity.Petun;
import com.monicatifanyz.cekula.Activity.activity.PetunjukActivity;
import com.monicatifanyz.cekula.Activity.activity.PetunjukPGActivity;
import com.monicatifanyz.cekula.Activity.activity.ReferensiActivity;
import com.monicatifanyz.cekula.Activity.activity.SplashScreenActivity;
import com.monicatifanyz.cekula.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewKompetensi, imageViewMateri, imageViewEvaluasi, imageViewReferensi, imageViewPetunjuk, imageViewPengembang, imageViewHome, imageViewKeluar;
    TextView teks, namanya, siap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siap = findViewById(R.id.tvSiap);
        namanya = findViewById(R.id.tvName);
        imageViewKompetensi = findViewById(R.id.ivKompetensi);
        imageViewMateri = findViewById(R.id.ivMateri);
        imageViewEvaluasi = findViewById(R.id.ivEvaluasi);
        imageViewReferensi = findViewById(R.id.ivReferensi);
        imageViewPetunjuk = findViewById(R.id.ivPetunjuk);
        imageViewPengembang = findViewById(R.id.ivPengembang);
        imageViewHome =findViewById(R.id.ivHome);
        imageViewKeluar = findViewById(R.id.ivkeluar);


        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        String nama = sharedPreferences.getString("nama", "");
        namanya.setText(nama);

//        //get value from login Activity
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("nama");
//        namanya.setText(str);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

        imageViewEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuEvaluasi(imageViewEvaluasi);
            }
        });
        imageViewReferensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuReferensi(imageViewReferensi);
            }
        });

        imageViewPengembang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuPengembang(imageViewPengembang);
            }
        });

        imageViewPetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuPetunjuk(imageViewPetunjuk);
            }
        });

        imageViewKompetensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuKompetensi(imageViewKompetensi);
            }
        });

        imageViewMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuMateri(imageViewMateri);
            }
        });

        imageViewKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });


    }

    public void menuUtama(View v){
        Intent menuUtama = new Intent(this, MainActivity.class);
        startActivity(menuUtama);
    }

    public void menuEvaluasi(View v){
        Intent eval = new Intent(this, PetunjukPGActivity.class);
        startActivity(eval);
    }

    public void menuKompetensi(View v){
        Intent komp = new Intent(this, KompetensiActivity.class);
        startActivity(komp);
    }

    public void  menuMateri(View v){
        Intent materi = new Intent(this, MateriActivity.class);
        startActivity(materi);
    }

    public void  menuPetunjuk(View v){
        Intent petunjuk = new Intent(this, Petun.class);
        startActivity(petunjuk);
    }

    public void  menuPengembang(View v){
        Intent pengembang = new Intent(this, PengembangActivity.class);
        startActivity(pengembang);
    }

    public void  menuReferensi(View v){
        Intent referensi = new Intent(this, ReferensiActivity.class);
        startActivity(referensi);
    }

    public void Exit(){
        Intent i = new Intent(getApplicationContext(), SplashScreenActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("EXIT", true);
        startActivity(i);
        finish();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Menghapus Status login
        SharedPreferences preferences = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("nama");
        editor.commit();
        finish();
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }


}
