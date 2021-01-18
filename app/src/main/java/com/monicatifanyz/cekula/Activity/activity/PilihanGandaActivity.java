package com.monicatifanyz.cekula.Activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.Activity.model.SoalPilihanGanda;
import com.monicatifanyz.cekula.R;

public class PilihanGandaActivity extends AppCompatActivity {

    private static PilihanGandaActivity instance;

    //membuat variabel baru sesuai tipe
    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3,  mrbPilihanJawaban4, mrbPilihanJawaban5;
    ImageView mbtnSubmit, mbtnHome;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang
    String jawaban; //menampung jawaban benar
    String namanya = "";
    String kelasnya = "";
    String absennya = "";

    //membuat objek dari kelas SoalPilihanGanda.java
    SoalPilihanGanda soalPG = new SoalPilihanGanda();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_ganda);
//
//        Toast.makeText(this, String.valueOf(savedInstanceState) , Toast.LENGTH_SHORT).show();
        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            namanya = b.getString("nama");
            kelasnya = b.getString("kelas");
            absennya = b.getString("absen");
//            Toast.makeText(this, namanya, + Toast.LENGTH_SHORT).show();
        }
        //menyambungkan antara variabel KuisPilihanGanda.java dengan id activity_kuis_pilihan_ganda
        mtvSkor = (TextView) findViewById(R.id.tvSkor);
        mtvSoal = (TextView) findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4 = (RadioButton) findViewById(R.id.rbPilihanJawaban4);
        mrbPilihanJawaban5 = (RadioButton) findViewById(R.id.rbPilihanJawaban5);
        mbtnSubmit =  findViewById(R.id.btnSubmit);


        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban();
            }
        });


    }


    public void  setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.pertanyaan.length;
        if(x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)

            Intent i = new Intent(PilihanGandaActivity.this, Hasil.class);

            i.putExtra("nama", namanya);
            i.putExtra("absen", absennya);
            i.putExtra("kelas", kelasnya);
            i.putExtra("skorAkhir",skor);
            startActivity(i);

        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalPilihanGanda
            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            mrbPilihanJawaban4.setText(soalPG.getPilihanJawaban4(x));
            mrbPilihanJawaban5.setText(soalPG.getPilihanJawaban5(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){ //jika radio button 1 diklik
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 4;
                setKonten(); //update next konten
            }else{
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 4;
                setKonten(); //update next konten
            }else{
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()) {
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if (mrbPilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 4;
                setKonten(); //update next konten
            } else {
                setKonten();
            }
        }
         else if(mrbPilihanJawaban4.isChecked()) {
                //jika text yang tertulis di radio button tsb = nilai dari var jawaban
                if (mrbPilihanJawaban4.getText().toString().equals(jawaban)) {
                    skor = skor + 4;
                    setKonten(); //update next konten
                } else {
                    setKonten();
                }
            }
         else if(mrbPilihanJawaban5.isChecked()){
                    //jika text yang tertulis di radio button tsb = nilai dari var jawaban
                    if(mrbPilihanJawaban5.getText().toString().equals(jawaban)){
                        skor = skor + 4;
                        setKonten(); //update next konten
                    }else{
                        setKonten();
                    }
        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }


    }



    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }
}

