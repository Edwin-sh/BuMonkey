package com.example.bumonkey.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.entidades.Gastos
import com.example.bumonkey.databinding.FragmentItemShowBinding

class GastosRecyclerViewAdapter(
    private val gastosList: List<Gastos>
) : RecyclerView.Adapter<GastosRecyclerViewAdapter.ViewHolder>() {

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
        val item = gastosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = gastosList.size

    inner class ViewHolder(binding: FragmentItemShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var nombreingreso: TextView = binding.textname
        private var imagen= binding.image

        fun render(gastosmodel: Gastos) {
            nombreingreso.text = gastosmodel.nombreingreso
            imagen.setImageResource(gastosmodel.imagen)
        }
    }

}