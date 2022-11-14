package com.example.bumonkey.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bumonkey.Ingresos
import com.example.bumonkey.R

class IngresosAdapter (private val ingresoslist:List<Ingresos>): RecyclerView.Adapter<IngresosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngresosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return IngresosViewHolder(layoutInflater.inflate(R.layout.recyclevista, parent, false))

    }

    override fun onBindViewHolder(holder: IngresosViewHolder, position: Int) {
        val item = ingresoslist[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return ingresoslist.size
    }
}


