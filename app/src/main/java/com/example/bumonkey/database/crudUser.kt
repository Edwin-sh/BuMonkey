package com.example.bumonkey.database

import android.content.ContentValues
import android.content.Context
import android.widget.Toast

class crudUser (){

        lateinit var bumonkeyDBHelper: mySQLiteHelper

        fun modificarSaldo(valor:Int,context: Context):Boolean{
            bumonkeyDBHelper= mySQLiteHelper(context)
            val valorCast=valor

            val args= arrayOf("1")
            val dbRead= bumonkeyDBHelper.readableDatabase
            val cursor = dbRead.rawQuery("SELECT * FROM user WHERE _id='1'", null)

            cursor.moveToLast()

            val datos=ContentValues()  //Nuevos parametros para actualizar
            datos.put("nombre",cursor.getString(1))
            datos.put("correo",cursor.getString(2))
            datos.put("user",cursor.getString(3))
            datos.put("password",cursor.getString(4))
            datos.put("cash",cursor.getInt(5)+valorCast)

            val dbWrite= bumonkeyDBHelper.writableDatabase  // la base de datos se pone en modo de escritura
            val res=dbWrite.update("user",datos,"_id=?",args)
            dbWrite.close()

            return res>0
        }

}