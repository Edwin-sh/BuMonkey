package com.example.bumonkey.adapter

import android.content.Context
import android.database.Cursor
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.database.mySQLiteHelper
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
        private var valor= binding.textvalue

        fun render(cursor: Cursor) {
            val db= mySQLiteHelper(context).readableDatabase
            val renderImg:Render=Render()

            val nombre=cursor.getString(1)
            val cursorFiltro:Cursor=db.rawQuery("SELECT * FROM reg_ingresos " +
                    "WHERE nombre='"+nombre+"'", null)
            var total=0
            val num=cursorFiltro.count

            if (num>0){
                cursorFiltro.moveToFirst()
                var pos=0
                while (pos<num){
                    total+=cursorFiltro.getInt(2)
                    cursorFiltro.moveToNext()
                    pos++
                }

            }
            nombreingreso.text = nombre
            imagen.setImageResource(renderImg.setImage(nombre))
            valor.text=total.toString()
        }
    }
}
