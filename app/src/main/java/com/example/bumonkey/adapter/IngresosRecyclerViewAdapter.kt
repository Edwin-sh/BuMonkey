package com.example.bumonkey.adapter

import android.content.Context
import android.database.Cursor
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.databinding.FragmentItemShowBinding

class IngresosRecyclerViewAdapter() : RecyclerView.Adapter<IngresosRecyclerViewAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var cursor: Cursor

    fun IngresosRecyclerViewAdapter(context: Context,cursor: Cursor){
        this.context=context
        this.cursor=cursor
    }
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
        cursor.moveToPosition(position)
        holder.render(cursor)
    }

    override fun getItemCount(): Int = cursor.count

    inner class ViewHolder(binding: FragmentItemShowBinding) : RecyclerView.ViewHolder(binding.root) {
        private var nombreingreso: TextView = binding.textname
        private var imagen= binding.image

        fun render(cursor: Cursor) {
            val renderImg:Render=Render()

            val nombre=cursor.getString(1)
            nombreingreso.text = nombre
            imagen.setImageResource(renderImg.setImage(nombre))
        }
    }
}
