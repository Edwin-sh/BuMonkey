package com.example.bumonkey.providers

import com.example.bumonkey.entidades.Gastos
import com.example.bumonkey.R

class GastosProvider {
    companion object {
        val gastoslist= listOf<Gastos>(
          Gastos("Arriendo", R.drawable.casa),
            Gastos("Transporte", R.drawable.publictransport),
            Gastos("Comida", R.drawable.img_comida),
            Gastos("Salud", R.drawable.img_salud),
            Gastos("Educación", R.drawable.img_educacion),
            Gastos("Ropa", R.drawable.img_ropa),
            Gastos("Viaje", R.drawable.img_viaje),
            Gastos("Servicios", R.drawable.img_serv_pub),
            Gastos("Impuestos", R.drawable.img_impuestos),
            Gastos("Otro", R.drawable.img_otro)
        )
    }
}