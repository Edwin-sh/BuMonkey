package com.example.bumonkey.fragments

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.bumonkey.R
import com.example.bumonkey.adapter.Render
import com.example.bumonkey.database.crudMovimientos
import com.example.bumonkey.database.mySQLiteHelper
import com.example.bumonkey.databinding.ActivityGo4Binding
import com.example.bumonkey.databinding.ActivityHomeBinding
import com.example.bumonkey.databinding.FragmentNuevoRegistroBinding
import com.example.bumonkey.home_activity

class NuevoRegistroFragment : Fragment() {
    private lateinit var bumonkeyDBHelper: mySQLiteHelper
    private lateinit var  db: SQLiteDatabase
    private lateinit var  cursor: Cursor
    // TODO: Rename and change types of parameters
    private var tipo: String? = null
    private var nombre: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tipo = it.getString("tipo")
            nombre = it.getString("nombre")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nuevo_registro, container, false)
        this.mostrarNuevo(view)
        return view
    }
    fun mostrarNuevo(view: View){
        val binding:FragmentNuevoRegistroBinding= FragmentNuevoRegistroBinding.bind(view)
        bumonkeyDBHelper = mySQLiteHelper(this.requireContext())
        db = bumonkeyDBHelper.readableDatabase
        val render=Render()

        if (this.tipo=="gasto"){
            cursor = db.rawQuery("SELECT * FROM cat_gastos WHERE nombre='"+this.nombre+"'", null)
        }else if(this.tipo=="ingreso"){
            cursor = db.rawQuery("SELECT * FROM cat_ingresos WHERE nombre='"+this.nombre+"'", null)
        }
        if (cursor.count>0){
            cursor.moveToLast()
            val name:String=cursor.getString(1)
            binding.textname.text=name
            binding.image.setImageResource(render.setImage(name))
        }

        binding.buttonAgregarRegistro.setOnClickListener {
            val crud=crudMovimientos()
            if (binding.edittextvaluenuevo.text.isNotBlank()){
                val tipo=this.tipo!!
                val nombre=binding.textname.text.toString()
                val valor= binding.edittextvaluenuevo.text.toString()
                val b:Boolean=crud.anadirReg(tipo, nombre, valor, requireContext())

                if (b){
                    Toast.makeText(requireContext(), "Guardao Correctamente", Toast.LENGTH_SHORT)
                    //home_activity.mostrarDatosUsuario(, bumonkeyDBHelper)
                }
            }
        }
    }
    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NuevoRegistroFragment().apply {
                arguments = Bundle().apply {
                    putString("nombre", param1)
                }
            }
    }
}