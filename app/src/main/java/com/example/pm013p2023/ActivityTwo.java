package com.example.pm013p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity  {

    Button btncreate, btnlist, bntvoz, btncombo, btnfototake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        btncreate = (Button)findViewById(R.id.btncreate);
        btnlist = (Button)findViewById(R.id.btnlist);
        bntvoz= (Button)findViewById(R.id.bntvoz);
        btncombo= (Button)findViewById(R.id.btncombo);
        btnfototake = (Button)findViewById(R.id.btnfototake);
        /* Creacion del los listener de los botones */

        View.OnClickListener butonclick = new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                 Class<?> actividad = null;

                if (view.getId() == R.id.btncreate) {
                    actividad = MainActivity.class;
                }
                else if (view.getId() == R.id.btnlist)
                {
                    actividad = ActivityList.class;
                }
                else if (view.getId() == R.id.btncombo)
                {
                    actividad = ActivityCombo.class;
                }
                else if (view.getId() == R.id.btnfototake)
                {
                    actividad = ActivityPhoto.class;
                }
                else if (view.getId() == R.id.bntvoz)
                {
                    actividad = ActivitySpeech.class;
                }

                if(actividad != null)
                {
                    NoveActivity(actividad);
                }
            }
        };
        btncreate.setOnClickListener(butonclick);
        btnlist.setOnClickListener(butonclick);
        bntvoz.setOnClickListener(butonclick);
        btncombo.setOnClickListener(butonclick);
        btnfototake.setOnClickListener(butonclick);
    }

    private void NoveActivity(Class<?> actividad)
    {
        Intent intent = new Intent(getApplicationContext(),actividad);
        startActivity(intent);
    }
}