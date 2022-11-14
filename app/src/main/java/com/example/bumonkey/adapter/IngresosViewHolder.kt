package com.example.bumonkey.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bumonkey.Ingresos
import com.example.bumonkey.R

class IngresosViewHolder (view: View): RecyclerView.ViewHolder(view){
    val nombreingreso=view.findViewById<TextView>(R.id.textingresos)
    val imagen=view.findViewById<ImageView>(R.id.imageningresos)

    fun render(ingresosmodel: Ingresos){
        nombreingreso.text=ingresosmodel.nombreingreso
        Glide.with(imagen.context).load(ingresosmodel.imagen).into(imagen)


    }


}