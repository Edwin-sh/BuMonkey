package com.example.bumonkey.adapter

import android.content.Context
import android.database.Cursor
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bumonkey.databinding.FragmentItemTipoBinding

import com.example.bumonkey.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TiposIngresosRecyclerViewAdapter(
    private val listener: TiposGastosRecyclerViewAdapter.OnItemClickListener
) : RecyclerView.Adapter<TiposIngresosRecyclerViewAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var cursor: Cursor

    fun TiposIngresosRecyclerViewAdapter(context: Context, cursor: Cursor){
        this.context=context
        this.cursor=cursor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemTipoBinding.inflate(
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

    inner class ViewHolder(binding: FragmentItemTipoBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        private var nombreingreso: TextView = binding.textname
        private var imagen= binding.image2

        init {
            itemView.setOnClickListener(this)
        }

        fun render(cursor: Cursor) {
            val renderImg:Render=Render()

            val nombre=cursor.getString(1)
            nombreingreso.text = nombre
            imagen.setImageResource(renderImg.setImage(nombre))
        }

        override fun onClick(v: View?) {
            listener.onItemClick(nombreingreso.text.toString())
        }
    }

}