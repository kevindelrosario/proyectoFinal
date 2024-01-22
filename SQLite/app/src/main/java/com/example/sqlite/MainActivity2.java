package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText editTarjeta, editEfectivo;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTarjeta=(EditText) findViewById(R.id.editTarjeta);
        editEfectivo=(EditText) findViewById(R.id.editEfectivo);
        btnAgregar =(Button) findViewById(R.id.btAgregarVenta);

        final SQLiteDB sqliteDB = new SQLiteDB(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String tarjet = editTarjeta.getText().toString();
                // con Float.parseFloat() pasamos el string a float
                sqliteDB.agregarVenta(Float.parseFloat(editTarjeta.getText().toString()),Float.parseFloat(editEfectivo.getText().toString()));
                Toast.makeText(getApplicationContext(),"SE AGREGÓ LA VENTA CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });


    }
}