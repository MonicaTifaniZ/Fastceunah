package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.Activity.activity.IsiDataActivity;
import com.monicatifanyz.cekula.R;

public class PetunjukPGActivity extends AppCompatActivity {

    Button buttonSiap;
    ImageView buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_p_g);

        buttonSiap = findViewById(R.id.btnGo);
        buttonHome = findViewById(R.id.ivHome);

        buttonSiap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuIsiData(buttonSiap);
            }
        });
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(buttonHome);
            }
        });


    }

    public  void menuIsiData(View v){
        Intent isiData = new Intent(this, IsiDataActivity.class);
        startActivity(isiData);
    }
    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
