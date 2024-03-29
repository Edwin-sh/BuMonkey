package com.example.bumonkey.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySQLiteHelper(context: Context):SQLiteOpenHelper(context, "bumonkey.db", null,15) {
    override fun onCreate(db: SQLiteDatabase?) {
        crear_tablas(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorradoUser="DROP TABLE IF EXISTS user"
        db!!.execSQL(ordenBorradoUser)

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

        val ordenCreacionUser="CREATE TABLE user"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "correo TEXT," +
                "user TEXT," +
                "password TEXT," +
                "cash INTEGER)"
        db!!.execSQL(ordenCreacionUser)

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
                "nombre TEXT," +
                "valor INTEGER)"
        db!!.execSQL(ordenCreacionRegIng)

        val ordenCreacionRegGas="CREATE TABLE reg_gastos"+
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "valor INTEGER)"
        db!!.execSQL(ordenCreacionRegGas)
    }

    fun crear_Datos_Iniciales(){
        val datosIni:datosIniciales=datosIniciales()
        datosIni.crear_user(this)
        datosIni.crear_tipos_ingresos(this)
        datosIni.crear_tipos_gastos(this)
    }
}