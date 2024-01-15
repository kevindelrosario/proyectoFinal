package com.example.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
  //variables que entran
    var txtTarjeta:EditText?=null
    var txtEfectivo:EditText?=null
    var vistaTotal:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //vinculacion
        txtTarjeta = findViewById(R.id.txtTarjeta)
        txtEfectivo = findViewById(R.id.txtEfectivo)
        vistaTotal= findViewById(R. id.vistaTotal)




        promedio()
    }
    //funciones


    /****************INSERTAR**********************/
    fun insertar(view: View){
        //creamos una coneccion
        var con = SQLite(this, "restaurante", null,1)

        //creamos la base de datos
        var baseDatos = con.writableDatabase

        //campos :  son de tipo string pero luego en la base de datos se cambian
        var tarjeta = txtTarjeta?.text.toString()
        var efectivo = txtEfectivo?.text.toString()

        //comprobamos si se ingresan
        if(tarjeta.isEmpty()== false && efectivo.isEmpty() == false){
            var registro = ContentValues() //ira ingresando los valores
            var suma: Float = tarjeta.toFloat()+ efectivo.toFloat()
            var total = "%.3f".format(suma)

            registro.put("tarjeta", tarjeta)
            registro.put("efectivo", efectivo)
            registro.put("total",total)

            baseDatos.insert("ventas",null,registro) //el null indica que no quiero que ninguna este null
            txtTarjeta?.setText("")
            txtEfectivo?.setText("")
            Toast.makeText(this, "se ha registrado los datos de la venta.", Toast.LENGTH_LONG).show()//muestra un mensaje
        }else{
            Toast.makeText(this, "Debe ingresar ambos datos", Toast.LENGTH_LONG).show()
        }
        baseDatos.close()
        promedio()
    }

    /****************SACAR PROMEDIO**********************/
    fun promedio() {
        var con = SQLite(this, "restaurante", null, 1)
        var baseDatos = con.writableDatabase

        var fila = baseDatos.rawQuery("select sum(total) from ventas",null)
        //consulta que suma todos los datos del campo total

        if (fila.moveToFirst() == true) {
            vistaTotal?.setText(fila.getString(0))
            baseDatos.close()
        } else {
            vistaTotal?.setText("0")
        }
    }



    }





