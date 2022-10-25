package com.example.bumonkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun login(buttoncancel: View){
        val login= Intent(this,LoginActivity3::class.java)
        startActivity(login)
    }
}