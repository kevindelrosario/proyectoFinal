package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDB extends SQLiteOpenHelper {

    private static final String NOMBRE_BD ="administracion.db";
    private static  final int VERSION_BD =1;
    private static final String TABLA_VENTAS="CREATE TABLE VENTAS(tarjeta real,efectivo real, total real)";

    public SQLiteDB(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_VENTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS "+ TABLA_VENTAS);
       db.execSQL(TABLA_VENTAS);
    }

    public void agregarVenta (float tarjeta, float efectivo){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            float total = tarjeta + efectivo;
            db.execSQL("INSERT INTO VENTAS('"+tarjeta+"','"+efectivo+"','"+total+"')");
            db.close();
        }
    }

}
