package com.example.bumonkey.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.entidades.Ingresos
import com.example.bumonkey.databinding.FragmentItemShowBinding

class IngresosRecyclerViewAdapter(
    private val ingresosList: List<Ingresos>
) : RecyclerView.Adapter<IngresosRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ingresosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = ingresosList.size

    inner class ViewHolder(binding: FragmentItemShowBinding) : RecyclerView.ViewHolder(binding.root) {
        private var nombreingreso: TextView = binding.textname
        private var imagen= binding.image

        fun render(ingresosmodel: Ingresos) {
            nombreingreso.text = ingresosmodel.nombreingreso
           imagen.setImageResource(ingresosmodel.imagen)
        }
    }
}
