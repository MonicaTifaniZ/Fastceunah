package com.monicatifanyz.cekula.Activity.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;

public class HasilSkoring extends AppCompatActivity implements View.OnClickListener {

    TextView mtvHasilAkhir, mtvNama, mtvAbsen, mtvKelas, mtvKetLulus, mtvKetTidakLulus;
    Button mbtnReview, mbtnKirim;
    ImageView imageViewHome;

    String nama = "";
    String absen = "";
    String kelas = "";
    int skorPilGan = 0;

    PilihanGandaActivity pg = new PilihanGandaActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_skoring);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
//            if (bundle != null){
            nama = bundle.getString("nama");
            kelas = bundle.getString("kelas");
            absen = bundle.getString("absen");
            skorPilGan = bundle.getInt("skorAkhir");
//            }
        }

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mtvNama = (TextView) findViewById(R.id.textViewNama);
        mtvAbsen = (TextView) findViewById(R.id.textViewAbsen);
        mtvKelas = (TextView) findViewById(R.id.textViewKelas);
        mbtnReview = (Button) findViewById(R.id.btnKoreksi);
        mbtnKirim = (Button) findViewById(R.id.btnKirim);
        imageViewHome = (ImageView) findViewById(R.id.ivHome);

        mtvKetLulus = (TextView) findViewById(R.id.textViewKetLulus);
        mtvKetTidakLulus = (TextView) findViewById(R.id.textViewKetTidak);

        setData();
    }

    public void setData() {
        //hasil lemparan (putExtra) dari activity sebelumnya ditampung dalam variabel lokal
//        Bundle extras = getIntent().getExtras();
//            String nama = getIntent().getStringExtra("nama");
//            String absen = getIntent().getStringExtra("absen");
//            String kelas = getIntent().getStringExtra("kelas");
//            int skorPilGan = getIntent().getIntExtra("skorAkhir",0);

        if (skorPilGan >= 75){
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
    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void kirimEmail(View v){
        Log.i("Send email", "");
        String[] TO = {"171111077@mhs.stiki.ac.id"};
        String[] CC = {""};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        String mycontent = "Nama Lengkap\t: "+nama +"\n" + "Nomor Absen\t: "+absen +"\n"  +"Kelas\t\t: "+kelas +"\n"+ "Skor\t\t: "+skorPilGan +"\n";


//            emailIntent.setData(Uri.parse("mailto:monicatifany99@gmail.com"));
        emailIntent.setType("application/octet-stream");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//            emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hasil Evaluasi Pilihan Ganda");
        emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
        startActivity(Intent.createChooser(emailIntent, " Send mail"));

//            try {
//                Toast.makeText(HasilSkoring.this, "Email berhasil terkirim", Toast.LENGTH_SHORT).show();
//                finish();
//            } catch (android.content.ActivityNotFoundException ex){
//                Toast.makeText(HasilSkoring.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
//            }

    }

    public  void menuReview(View v){
        Intent intent = new Intent(HasilSkoring.this, ReviewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent n = new Intent(HasilSkoring.this, MainActivity.class);
        startActivity(n);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewHome){
            menuUtama(imageViewHome);
        } else if (v == mbtnKirim){
            kirimEmail(mbtnKirim);
        } else if (v == mbtnReview){
            menuReview(mbtnReview);
        }
    }


}





