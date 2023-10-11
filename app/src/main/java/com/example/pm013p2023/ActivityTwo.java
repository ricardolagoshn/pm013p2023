package com.example.pm013p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity {

    Button btncreate, btnlist, bntvoz, btncombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btncreate = (Button)findViewById(R.id.btncreate);
        btnlist = (Button)findViewById(R.id.btnlist);
        bntvoz= (Button)findViewById(R.id.bntvoz);
        btncombo= (Button)findViewById(R.id.btncombo);
        /* Creacion del los listener de los botones */

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentcreate);
            }
        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intentcreate);
            }
        });

        bntvoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), ActivitySpeech.class);
                startActivity(intentcreate);
            }
        });

        btncombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcreate = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intentcreate);
            }
        });


    }
}