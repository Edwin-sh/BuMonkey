package com.example.bumonkey.database;

import android.content.ContentValues

public class datosIniciales(){

    fun crear_user(db:mySQLiteHelper){

        val tb=db.readableDatabase
        val cursor = tb.rawQuery("SELECT * FROM user", null)

        if (cursor.count < 1){
            val datos1= ContentValues()
            datos1.put("nombre","User Bumonkey")
            datos1.put("correo","bumonkey@gmail.com")
            datos1.put("user","bumonkey")
            datos1.put("password","GP3")
            datos1.put("cash","50000")

            val db=db.writableDatabase  // la base de datos se pone en modo de escritura
            db.insert("user",null,datos1)
        }
    }

    fun crear_tipos_gastos(db:mySQLiteHelper){

        val tb=db.readableDatabase
        val cursor = tb.rawQuery("SELECT * FROM cat_gastos", null)

        if (cursor.count < 1){
            val datos1= ContentValues()
            datos1.put("nombre","Arriendo")

            val datos2=ContentValues()
            datos2.put("nombre","Transporte")

            val datos3=ContentValues()
            datos3.put("nombre","Comida")

            val datos4=ContentValues()
            datos4.put("nombre","Salud")

            val datos5=ContentValues()
            datos5.put("nombre","Educación")

            val datos6=ContentValues()
            datos6.put("nombre","Ropa")

            val datos7=ContentValues()
            datos7.put("nombre","Viaje")

            val datos8=ContentValues()
            datos8.put("nombre","Servicios")

            val datos9=ContentValues()
            datos9.put("nombre","Impuestos")

            val datos10=ContentValues()
            datos10.put("nombre","Otro")

            val db=db.writableDatabase  // la base de datos se pone en modo de escritura
            db.insert("cat_gastos",null,datos1)
            db.insert("cat_gastos",null,datos2)
            db.insert("cat_gastos",null,datos3)
            db.insert("cat_gastos",null,datos4)
            db.insert("cat_gastos",null,datos5)
            db.insert("cat_gastos",null,datos6)
            db.insert("cat_gastos",null,datos7)
            db.insert("cat_gastos",null,datos8)
            db.insert("cat_gastos",null,datos9)
            db.insert("cat_gastos",null,datos10)
            db.close()
        }
    }

    fun crear_tipos_ingresos(db:mySQLiteHelper){

        val tb=db.readableDatabase
        val cursor = tb.rawQuery("SELECT * FROM cat_ingresos", null)

        if (cursor.count < 1){
            val datos1= ContentValues()
            datos1.put("nombre","Empleo")

            val datos2=ContentValues()
            datos2.put("nombre","Ventas")

            val datos3=ContentValues()
            datos3.put("nombre","Regalo")

            val datos4=ContentValues()
            datos4.put("nombre","Prima")

            val datos5=ContentValues()
            datos5.put("nombre","Subsidio")

            val datos6=ContentValues()
            datos6.put("nombre","Otro")

            val db=db.writableDatabase  // la base de datos se pone en modo de escritura
            db.insert("cat_ingresos",null,datos1)
            db.insert("cat_ingresos",null,datos2)
            db.insert("cat_ingresos",null,datos3)
            db.insert("cat_ingresos",null,datos4)
            db.insert("cat_ingresos",null,datos5)
            db.insert("cat_ingresos",null,datos6)
            db.close()
        }
    }
}
