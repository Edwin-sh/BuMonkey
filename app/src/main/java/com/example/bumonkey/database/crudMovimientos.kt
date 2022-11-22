package com.example.bumonkey.database

import android.content.ContentValues
import android.content.Context
import android.widget.Toast

class crudMovimientos() {

        lateinit var bumonkeyDBHelper: mySQLiteHelper
        val crudUs=crudUser()
        fun anadirReg(tipo: String, nombre:String, valor:String,context: Context):Boolean{

            bumonkeyDBHelper= mySQLiteHelper(context)
            val valorCast:Int=valor.toInt()
            val datos= ContentValues()  //mainipulacion de datos Clave Valor

            datos.put("nombre",nombre)
            datos.put("valor", valorCast)

            val db= bumonkeyDBHelper.writableDatabase  // la base de datos se pone en modo de escritura
            var res:Long=0

            if (tipo=="gasto"){
                //guardar los datos
                res=db.insert("reg_gastos",null,datos)
                if (res>0){
                    Toast.makeText(context, "Exxito", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Errorrr", Toast.LENGTH_SHORT).show()
                }
                db.close()
                return if (res>0){
                    crudUs.modificarSaldo(-valorCast, context)
                }else{
                    false
                }
            }else if(tipo=="ingreso"){
                //guardar los datos
                res=db.insert("reg_ingresos",null,datos)
                db.close()
                return if (res>0){
                    crudUs.modificarSaldo(valorCast, context)
                }else{
                    false
                }
            }else{
                db.close()
                return false
            }
        }
}
