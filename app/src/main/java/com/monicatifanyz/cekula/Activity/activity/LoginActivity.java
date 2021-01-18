package com.monicatifanyz.cekula.Activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.monicatifanyz.cekula.Activity.MainActivity;
import com.monicatifanyz.cekula.R;


public class LoginActivity extends AppCompatActivity {
    EditText editTextName ;


    //Declaration Button
    Button buttonLogin;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        editTextName = findViewById(R.id.editTextNama);
        buttonLogin = findViewById(R.id.btnGo);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masuk();
            }
        });

    }



    /** Menuju ke MainActivity dan Set User dan Status sedang login, di Preferences */
    private void masuk(){

        String nama = editTextName.getText().toString().trim();
        if (editTextName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),
                            "Nama tidak boleh kosong!",Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nama", nama);
            editor.apply();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }


}

