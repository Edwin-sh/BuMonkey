package com.example.bumonkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistreActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre2)
    }
    fun home(buttoncancel: View) {
        val cancel = Intent(this, MainActivity::class.java)
        startActivity(cancel)
    }
    fun login(buttonlogin: View){
        val login= Intent(this,LoginActivity3::class.java)
        startActivity(login)
    }
}