package com.example.bumonkey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class RegistreActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre2)
    }
    fun home(buttoncancel: View) {
        val cancel = Intent(this, MainActivity::class.java)
        startActivity(cancel)
        Toast.makeText(this,R.string.Toast_butt_cancel, Toast.LENGTH_LONG).show()
    }
    fun login(buttonlogin: View){
        val login= Intent(this,LoginActivity3::class.java)
        startActivity(login)
        Toast.makeText(this,R.string.Toast_butt_registreOK, Toast.LENGTH_LONG).show()
    }
}