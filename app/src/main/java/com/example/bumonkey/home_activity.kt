package com.example.bumonkey

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bumonkey.database.mySQLiteHelper
import com.example.bumonkey.fragments.GastosFragment
import com.example.bumonkey.fragments.IngresosFragment
import com.google.android.material.navigation.NavigationView

class home_activity : AppCompatActivity() {
    private lateinit var appbarConfiguration: AppBarConfiguration
    lateinit var bumonkeyDBHelper: mySQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        bumonkeyDBHelper= mySQLiteHelper(this)

        bumonkeyDBHelper.crear_Datos_Iniciales()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragcontainer) as NavHostFragment
        val navController = navHostFragment.navController

        appbarConfiguration = AppBarConfiguration(setOf(R.id.nav_item_gastos, R.id.nav_item_ingresos), drawerLayout)

        setupActionBarWithNavController(navController, appbarConfiguration)
        navView.setupWithNavController(navController)

        val btnFlotane: View = findViewById(R.id.btnFlotante)
        btnFlotane.setOnClickListener { view ->
            contexto(view)
            bumonkeyDBHelper.crear_Datos_Iniciales()
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragcontainer) as NavHostFragment
        val navController =  navHostFragment.navController
        return navController.navigateUp(appbarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {

        /*R.id.help -> {
            val positiveButton = { dialog: DialogInterface, entero: Int -> }

            val alert = AlertDialog.Builder(this).setTitle(R.string.Alert_dialog_tittle_help)
                .setMessage(R.string.Alert_dialog_message_help)
                .setPositiveButton("OK", positiveButton)
                .create().show()
            true
        }*/

        R.id.search -> {
            Toast.makeText(this, R.string.Toast_search, Toast.LENGTH_LONG).show()
            true
        }

        R.id.edit -> {
            Toast.makeText(this, R.string.Toast_edit, Toast.LENGTH_LONG).show()
            true
        }

        R.id.delete -> {
            Toast.makeText(this, R.string.Toast_delete, Toast.LENGTH_LONG).show()
            true
        }

        R.id.email -> {
            Toast.makeText(this, R.string.Toast_email, Toast.LENGTH_LONG).show()
            true
        }

        R.id.upload -> {
            Toast.makeText(this, R.string.Toast_upload, Toast.LENGTH_LONG).show()
            true
        }

        R.id.exit -> {
            Toast.makeText(this, R.string.Alert_dialog_tittle_exit, Toast.LENGTH_LONG).show()
            val exit = Intent(this, MainActivity::class.java)
            startActivity(exit)
            Toast.makeText(this, R.string.Alert_dialog_message_exit, Toast.LENGTH_LONG).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun contexto(view:View){
        val NavHostFrag: NavHostFragment= supportFragmentManager.findFragmentById(R.id.fragcontainer) as NavHostFragment
        val frag: Fragment? =NavHostFrag.childFragmentManager?.fragments?.get(0)

        if (frag is GastosFragment){
        Toast.makeText(/* context = */ this, "Es gasto",/* text = */
            Toast.LENGTH_SHORT).show()

        }else if(frag is IngresosFragment)
        {
            Toast.makeText(/* context = */ this, "Es ingreso",/* text = */
                Toast.LENGTH_SHORT).show()
        }
    }

}
