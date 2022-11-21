package com.example.bumonkey.adapter

import com.example.bumonkey.R

class Render(){
    fun setImage(nombre:String): Int {

        when(nombre) {
            //Ingresos
            "Empleo" -> return (R.drawable.programador)
            "Ventas" -> return (R.drawable.ventas)
            "Regalo" -> return (R.drawable.giftbox)
            "Prima" -> return (R.drawable.img_prima)
            "Subsidio" -> return (R.drawable.img_subsidio)

            //Gastos
            "Arriendo" -> return (R.drawable.casa)
            "Transporte" -> return (R.drawable.publictransport)
            "Comida" -> return (R.drawable.img_comida)
            "Salud" -> return (R.drawable.img_salud)
            "Educación" -> return (R.drawable.img_educacion)
            "Ropa" -> return (R.drawable.img_ropa)
            "Viaje" -> return (R.drawable.img_viaje)
            "Servicios" -> return (R.drawable.img_serv_pub)
            "Impuestos" -> return (R.drawable.img_impuestos)

            //Otro
            "Otro" -> return (R.drawable.img_otro)


            else -> {
                return R.drawable.ic_launcher_background
            }
        }
    }
}