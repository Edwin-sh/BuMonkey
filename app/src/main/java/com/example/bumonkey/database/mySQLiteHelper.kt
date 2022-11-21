package com.example.bumonkey.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySQLiteHelper(context: Context):SQLiteOpenHelper(context, "bumonkey.db", null,9) {
    override fun onCreate(db: SQLiteDatabase?) {
        crear_tablas(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorradoIng="DROP TABLE IF EXISTS cat_ingresos"
        db!!.execSQL(ordenBorradoIng)
        val ordenBorradoGas="DROP TABLE IF EXISTS cat_gastos"
        db!!.execSQL(ordenBorradoGas)
        val ordenBorradoRegIng="DROP TABLE IF EXISTS reg_ingresos"
        db!!.execSQL(ordenBorradoRegIng)
        val ordenBorradoRegGas="DROP TABLE IF EXISTS reg_gastos"
        db!!.execSQL(ordenBorradoRegGas)
        onCreate(db)
    }

    fun crear_tablas(db: SQLiteDatabase?){
        val ordenCreacionIng="CREATE TABLE cat_ingresos"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)"
        db!!.execSQL(ordenCreacionIng)

        val ordenCreacionGas="CREATE TABLE cat_gastos"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)"
        db!!.execSQL(ordenCreacionGas)

        val ordenCreacionRegIng="CREATE TABLE reg_ingresos"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)"
        db!!.execSQL(ordenCreacionRegIng)

        val ordenCreacionRegGas="CREATE TABLE reg_gastos"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)"
        db!!.execSQL(ordenCreacionRegGas)
    }

    fun crear_Datos_Iniciales(){
        val datosIni:datosIniciales=datosIniciales()
        datosIni.crear_tipos_ingresos(this)
        datosIni.crear_tipos_gastos(this)
    }
}