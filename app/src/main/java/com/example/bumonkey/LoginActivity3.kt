package com.example.bumonkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class LoginActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login3)
    }

    fun home(buttoncancel:View){
        val cancel= Intent(this,MainActivity::class.java)
        startActivity(cancel)
    }

    fun go(buttoncancel:View){
        val login= Intent(this,GoActivity4::class.java)
        startActivity(login)
    }

}