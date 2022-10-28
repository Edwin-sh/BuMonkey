package com.example.bumonkey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

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

}