package com.example.bumonkey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bumonkey.adapter.IngresosAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(buttonlogin: View){
        val login= Intent(this,LoginActivity3::class.java)
        startActivity(login)
        Toast.makeText(this,R.string.Toast_butt_login3, Toast.LENGTH_LONG).show()
    }
    fun register(buttonregistre: View){
        val register= Intent(this,RegistreActivity2::class.java)
        startActivity(register)
        Toast.makeText(this,R.string.Toast_butt_registre2, Toast.LENGTH_LONG).show()
    }

    fun iniciarrecycler(){
        val recyclerView=findViewById<RecyclerView>(R.id.reingresos)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=IngresosAdapter(ingresosProvider.ingresoslist)


    }

}