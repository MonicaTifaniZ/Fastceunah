package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.monicatifanyz.cekula.R;

public class IsiDataActivity extends AppCompatActivity {

    Button btn;

    EditText etNamaLengkap, etNoAbsen, etKelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_data);

        btn = findViewById(R.id.btnGo);
        etNamaLengkap = findViewById(R.id.editTextNama);
        etNoAbsen = findViewById(R.id.editTextAbsen);
        etKelas = findViewById(R.id.editTextKelas);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaLengkap.getText().toString();
                String absen = etNoAbsen.getText().toString();
                String kelas = etKelas.getText().toString();

                if (etNamaLengkap.getText().toString().isEmpty() || etNoAbsen.getText().toString().isEmpty() || etKelas.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Data tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(IsiDataActivity.this, PilihanGandaActivity.class);
                    i.putExtra("nama", nama);
                    i.putExtra("absen", absen);
                    i.putExtra("kelas", kelas);
                    startActivity(i);

                    menuSoalPG(btn);
                }


            }
        });


    }



    public void menuSoalPG(View v){
        Intent pg = new Intent(this, PilihanGandaActivity.class);
        startActivity(pg);
    }
}
