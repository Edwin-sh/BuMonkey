package com.example.bumonkey

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class GoActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_go4)
        setSupportActionBar(findViewById(R.id.toolbar))
        this.llamargastos(null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean=when(item.itemId) {

        R.id.help->{
            val positiveButton={ dialog: DialogInterface, entero:Int-> }

            val alert = AlertDialog.Builder(this).setTitle(R.string.Alert_dialog_tittle_help)
                .setMessage(R.string.Alert_dialog_message_help)
                .setPositiveButton("OK",positiveButton)
                .create().show()
            true
        }

        R.id.search->{
            Toast.makeText(this,R.string.Toast_search,Toast.LENGTH_LONG).show()
            true
        }

        R.id.edit->{
            Toast.makeText(this,R.string.Toast_edit,Toast.LENGTH_LONG).show()
            true
        }

        R.id.delete->{
            Toast.makeText(this,R.string.Toast_delete,Toast.LENGTH_LONG).show()
            true
        }

        R.id.email->{
            Toast.makeText(this,R.string.Toast_email,Toast.LENGTH_LONG).show()
            true
        }

        R.id.upload->{
            Toast.makeText(this,R.string.Toast_upload,Toast.LENGTH_LONG).show()
            true
        }

        R.id.exit->{
            Toast.makeText(this,R.string.Alert_dialog_tittle_exit,Toast.LENGTH_LONG).show()
            val exit= Intent(this,MainActivity::class.java)
            startActivity(exit)
            Toast.makeText(this,R.string.Alert_dialog_message_exit, Toast.LENGTH_LONG).show()
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }

       // return super.onOptionsItemSelected(item)
    }

    fun llamargastos(view: View?){
        if (view!=null){
            Toast.makeText(this, getString(R.string.Toast_expenses), Toast.LENGTH_SHORT).show()
        }
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragcontainer, gastos_fragment::class.java, null, "tarea")
            .commit()
    }

    fun llamaringresos(view: View?){
        if (view!=null){
            Toast.makeText(this, getString(R.string.Toast_earnings), Toast.LENGTH_SHORT).show()
        }

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragcontainer, ingresos_fragment::class.java, null, "tarea2")
            .commit()
    }
}