package com.example.bumonkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity3 : AppCompatActivity() {
    private var edtuser:EditText?=null
    private var edtpassword:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login3)

        edtuser=findViewById(R.id.editTextTextEmailAddress)
        edtpassword=findViewById(R.id.editTextTextPassword)
    }

    fun home(buttoncancel:View){
        val cancel= Intent(this,MainActivity::class.java)
        startActivity(cancel)
    }

    fun go(buttonloging:View) {
        var username: String = edtuser!!.text.toString()
        var password: String = edtpassword!!.text.toString()

        if (username == "grupo3@bumonkey.com" && password == "bumonkeyGP3") {
            val login = Intent(this, GoActivity4::class.java)
            startActivity(login)

        } else {
            val alert = AlertDialog.Builder(this).setTitle("ERROR")
                .setMessage("USER/PASSWORD INCORRECT").create().show()
        }
    }


}