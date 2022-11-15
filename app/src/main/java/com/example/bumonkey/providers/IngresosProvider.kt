package com.example.bumonkey.providers

import com.example.bumonkey.entidades.Ingresos
import com.example.bumonkey.R

class IngresosProvider {
    companion object {
        val ingresoslist= listOf<Ingresos>(
          Ingresos("Empleo", R.drawable.programador),
        Ingresos("Ventas", R.drawable.ventas),
            Ingresos("Regalo", R.drawable.giftbox),
            Ingresos("Prima", R.drawable.img_prima),
            Ingresos("Subsidio", R.drawable.img_subsidio),
            Ingresos("Otro", R.drawable.img_otro)
        )
    }
}