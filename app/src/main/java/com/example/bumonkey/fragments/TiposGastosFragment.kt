package com.example.bumonkey.fragments

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bumonkey.R
import com.example.bumonkey.adapter.TiposGastosRecyclerViewAdapter
import com.example.bumonkey.database.mySQLiteHelper

/**
 * A fragment representing a list of Items.
 */
class TiposGastosFragment() : Fragment(), TiposGastosRecyclerViewAdapter.OnItemClickListener{
    private lateinit var bumonkeyDBHelper: mySQLiteHelper
    private lateinit var  db: SQLiteDatabase
    private lateinit var  cursor: Cursor

    private var columnCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bumonkeyDBHelper = mySQLiteHelper(this.requireContext())

        db = bumonkeyDBHelper.readableDatabase
        cursor = db.rawQuery("SELECT * FROM cat_gastos", null)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tipo_list, container, false)

        val item=this
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                val adaptador= TiposGastosRecyclerViewAdapter(item)
                adaptador.TiposGastosRecyclerViewAdapter(context, cursor)
                adapter = adaptador
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            TiposGastosFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onItemClick(name: String) {
        var data=Bundle()
        data.putString("tipo","gasto")
        data.putString("nombre",name)

        var fragment= NuevoRegistroFragment()
        fragment.arguments=data

        val fragm=requireFragmentManager().beginTransaction()
        fragm.replace(R.id.fragcontainer, fragment).addToBackStack(null)
        fragm.commit()

    }

}