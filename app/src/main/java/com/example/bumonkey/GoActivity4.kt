package com.example.bumonkey

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class GoActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_go4)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean=when(item.itemId) {

        R.id.help->{
            val positiveButton={ dialog: DialogInterface, entero:Int-> }

            val alert = AlertDialog.Builder(this).setTitle("HELP")
                .setMessage("PLEASE CONTACT US grupo3@bumonkey.com")
                .setPositiveButton("OK",positiveButton)
                .create().show()
            true
        }

        R.id.search->{
            Toast.makeText(this,"entro al item buscar",Toast.LENGTH_LONG).show()
            true
        }

        R.id.edit->{
            Toast.makeText(this,"entro al item editar",Toast.LENGTH_LONG).show()
            true
        }

        R.id.delete->{
            Toast.makeText(this,"entro al item eliminar",Toast.LENGTH_LONG).show()
            true
        }

        R.id.email->{
            Toast.makeText(this,"entro al item compartir",Toast.LENGTH_LONG).show()
            true
        }

        R.id.upload->{
            Toast.makeText(this,"entro al item subir",Toast.LENGTH_LONG).show()
            true
        }

        R.id.exit->{
            Toast.makeText(this,"SALIR",Toast.LENGTH_LONG).show()
            val exit= Intent(this,MainActivity::class.java)
            startActivity(exit)
            Toast.makeText(this,R.string.Toast_butt_cancel, Toast.LENGTH_LONG).show()
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }

       // return super.onOptionsItemSelected(item)
    }

}