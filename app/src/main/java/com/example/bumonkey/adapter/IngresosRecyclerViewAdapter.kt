package com.example.bumonkey.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.entidades.Ingresos
import com.example.bumonkey.databinding.FragmentItemIngresoBinding

class IngresosRecyclerViewAdapter(
    private val ingresosList: List<Ingresos>
) : RecyclerView.Adapter<IngresosRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemIngresoBinding.inflate(
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

    inner class ViewHolder(binding: FragmentItemIngresoBinding) : RecyclerView.ViewHolder(binding.root) {
        private var nombreingreso: TextView = binding.textingresos
        private var imagen= binding.imageningresos

        fun render(ingresosmodel: Ingresos) {
            nombreingreso.text = ingresosmodel.nombreingreso
           imagen.setImageResource(ingresosmodel.imagen)
        }
    }
}
