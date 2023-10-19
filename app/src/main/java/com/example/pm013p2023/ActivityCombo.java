package com.example.pm013p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pm013p2023.Models.Personas;
import com.example.pm013p2023.configuracion.SQLiteConexion;
import com.example.pm013p2023.configuracion.Transacciones;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {

    SQLiteConexion conexion;
    Spinner combopersonas;
    EditText nombres, apellidos, correo;

    ArrayList<Personas> listperson;

    ArrayList<String> ArregloPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion =  new SQLiteConexion(this, Transacciones.namedb, null, 1);
        combopersonas = (Spinner) findViewById(R.id.spinner);
        nombres = (EditText) findViewById(R.id.cbnombre);
        apellidos = (EditText) findViewById(R.id.cbapellidos);
        correo = (EditText) findViewById(R.id.cbcorreo);

        GetPersons();

        ArrayAdapter<CharSequence> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ArregloPersonas );
        combopersonas.setAdapter(adp);

        combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nombres.setText(listperson.get(i).getNombres());
                apellidos.setText(listperson.get(i).getApellidos());
                correo.setText(listperson.get(i).getCorreo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void GetPersons()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        listperson = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersonas,null);
        while(cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            listperson.add(person);
        }

        cursor.close();
        FillCombo();
    }

    private void FillCombo()
    {
        ArregloPersonas = new ArrayList<String>();

        for(int i = 0; i < listperson.size(); i++)
        {
            ArregloPersonas.add(listperson.get(i).getId() + " - " +
                    listperson.get(i).getNombres() + " - " +
                    listperson.get(i).getApellidos() );
        }
    }
}