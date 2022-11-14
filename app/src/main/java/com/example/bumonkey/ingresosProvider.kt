package com.example.bumonkey

class ingresosProvider {
    companion object {
        val ingresoslist= listOf<Ingresos>(
          Ingresos("Empleo","@drawable/programador"),
        Ingresos("Ventas", "@drawable/ventas"),
            Ingresos("Regalo", "@drawable/giftbox"),
            Ingresos("Prima","http://clipart-library.com/clipart/233485.htm"),
            Ingresos("Intereses", "http://clipart-library.com/clipart/960332.htm"),
            Ingresos("Arriendo","http://clipart-library.com/clip-art/transparent-cartoon-house-16.htm"),
            Ingresos("Subsidio","http://clipart-library.com/clipart/cheque-signing-cliparts_14.htm")
        )
    }
}