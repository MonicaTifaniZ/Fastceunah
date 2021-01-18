package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.Activity.model.SoalPilihanGanda;
import com.monicatifanyz.cekula.R;

public class Hasil extends AppCompatActivity {

    TextView mtvHasilAkhir, mtvNama, mtvAbsen, mtvKelas, mtvKetLulus, mtvKetTidakLulus;
    Button mbtnReview, mbtnKirim;
    ImageView imageViewHome, imageViewKeluar;

    PilihanGandaActivity soalPG = new PilihanGandaActivity();
    SoalPilihanGanda soal1 = new SoalPilihanGanda();

    String soal = "";
    String pilihan1 = "";
    String pilihan2 = " ";
    String pilihan3 = " ";
    String pilihan4 = " ";
    String pilihan5 = " ";
    String jawab = "";
    String checked = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mtvNama = (TextView) findViewById(R.id.textViewNama);
        mtvAbsen = (TextView) findViewById(R.id.textViewAbsen);
        mtvKelas = (TextView) findViewById(R.id.textViewKelas);
        mbtnReview = (Button) findViewById(R.id.btnKoreksi);
        mbtnKirim = (Button) findViewById(R.id.btnKirim);
        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewKeluar = (ImageView)findViewById(R.id.ivkeluar);

        mtvKetLulus = (TextView) findViewById(R.id.textViewKetLulus);
        mtvKetTidakLulus = (TextView) findViewById(R.id.textViewKetTidak);




//        if (savedInstanceState == null) {
//            Bundle b = getIntent().getExtras();
//            soal = b.getString("soal");
//            pilihan1 = b.getString("pilihan1");
//            pilihan2 = b.getString("pilihan2");
//            pilihan3 = b.getString("pilihan3");
//            pilihan4 = b.getString("pilihan4");
//            pilihan5 = b.getString("pilihan5");
//            jawab = b.getString("jawaban");
//
////            Toast.makeText(this, namanya, + Toast.LENGTH_SHORT).show();
//        }

        setData();


        mbtnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimEmail(mbtnKirim);
            }
        });

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

        mbtnReview.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                menuReview(mbtnReview);
            }
       });

        imageViewKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });
    }


//    public void kirimData(){
//            Bundle b = getIntent().getExtras();
//            soal = b.getString("soal");
//            pilihan1 = b.getString("pilihan1");
//            pilihan2 = b.getString("pilihan2");
//            pilihan3 = b.getString("pilihan3");
//            pilihan4 = b.getString("pilihan4");
//            pilihan5 = b.getString("pilihan5");
//            jawab = b.getString("jawaban");
//
//
//        Intent i = new Intent(Hasil.this, ReviewActivity.class);
//        i.putExtra("soal", soal);
//        i.putExtra("pilihan1", pilihan1);
//        i.putExtra("pilihan2", pilihan2);
//        i.putExtra("pilihan3", pilihan3);
//        i.putExtra("pilihan4", pilihan4);
//        i.putExtra("pilihan5", pilihan5);
//        i.putExtra("checked", checked);
//        i.putExtra("jawaban", jawab);
//        startActivity(i);
//
////            Toast.makeText(this, namanya, + Toast.LENGTH_SHORT).show();
//
//    }



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

    public void setData() {
        String nama = getIntent().getStringExtra("nama");
        String absen = getIntent().getStringExtra("absen");
        String kelas = getIntent().getStringExtra("kelas");
        int skorPilGan = getIntent().getIntExtra("skorAkhir", 0);

        if (skorPilGan >= 75) {
            mtvKetTidakLulus.setVisibility(View.GONE);
            mtvKetLulus.setVisibility(View.VISIBLE);
            String nilai = String.valueOf(skorPilGan);
            mtvNama.setText(nama);
            mtvAbsen.setText(absen);
            mtvKelas.setText(kelas);
            mtvHasilAkhir.setText(nilai);
        } else {
            mtvKetLulus.setVisibility(View.GONE);
            mtvKetTidakLulus.setVisibility(View.VISIBLE);
            String nilais = String.valueOf(skorPilGan);
            mtvNama.setText(nama);
            mtvAbsen.setText(absen);
            mtvKelas.setText(kelas);
            mtvHasilAkhir.setText(nilais);
        }
    }


    public void menuUtama(View v) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void kirimEmail(View v) {
        String[] TO = {"dwiwidyawati112@gmail.com"};
        String[] CC = {""};

        String namanya = getIntent().getStringExtra("nama");
        String absennya = getIntent().getStringExtra("absen");
        String kelasnya = getIntent().getStringExtra("kelas");
        int skorPilGannya = getIntent().getIntExtra("skorAkhir", 0);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String mycontent = "Nama Lengkap\t: " + namanya + "\n" + "Nomor Absen\t: " + absennya + "\n" + "Kelas\t\t: " + kelasnya + "\n" + "Skor\t\t: " + skorPilGannya + "\n";

        emailIntent.setType("application/octet-stream");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//            emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hasil Evaluasi Pilihan Ganda");
        emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
        startActivity(Intent.createChooser(emailIntent, " Send mail"));
        finish();

    }

    public  void menuReview(View v){
        Intent intent = new Intent(Hasil.this, ReviewActivity.class);
        startActivity(intent);
    }
}
