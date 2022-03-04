package com.example.bottomnavwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.widget.Toolbar

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navController = findNavController(R.id.fragmentContainerView)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("")

        setSupportActionBar(toolbar)

        bottomNavigationView.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.dashbroadFragment,
                R.id.searchFragment,
                R.id.cartFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.nav_search){
            Toast.makeText(this, "Clicked search", Toast.LENGTH_SHORT)
        }
        if (item.itemId == R.id.nav_noti){
            Toast.makeText(this, "Clicked notifications", Toast.LENGTH_SHORT)
        }
        return super.onOptionsItemSelected(item)
    }
}