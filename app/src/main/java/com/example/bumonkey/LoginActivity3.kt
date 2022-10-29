package com.example.bumonkey

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
        Toast.makeText(this,R.string.Toast_butt_cancel, Toast.LENGTH_LONG).show()
    }

    fun go(buttonloging:View) {
        var username: String = edtuser!!.text.toString()
        var password: String = edtpassword!!.text.toString()

        val positiveButton={ dialog:DialogInterface,entero:Int->
            val login = Intent(this, GoActivity4::class.java)
            startActivity(login)
            Toast.makeText(this,R.string.Toast_butt_pos,Toast.LENGTH_LONG).show()

        }
        val negativeButton={ dialog:DialogInterface,entero:Int->
            Toast.makeText(this,R.string.Toast_butt_neg,Toast.LENGTH_LONG).show()
        }

        if (username == "juan" && password == "1234") {
            val alert = AlertDialog.Builder(this).setTitle(R.string.Alert_dialog_tittle_pos)
                .setMessage(R.string.Alert_dialog_message_pos)
                .setPositiveButton(R.string.possitive_button,positiveButton)
                .setNegativeButton(R.string.negative_button,negativeButton)
                .create().show()

        } else {
            val alert = AlertDialog.Builder(this).setTitle(R.string.Alert_dialog_tittle_neg)
                .setMessage(R.string.Alert_dialog_message_neg).create().show()
        }
    }


}