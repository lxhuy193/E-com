package com.example.bottomnavwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavwithfragment.fragments.CartFragment
import com.example.bottomnavwithfragment.fragments.DashbroadFragment
import com.example.bottomnavwithfragment.fragments.ProfileFragment
import com.example.bottomnavwithfragment.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val dashbroadFragment = DashbroadFragment()
    private val searchFragment = SearchFragment()
    private val cartFragment = CartFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
//        val navController = findNavController(R.id.fragment_container)

//        val toolbar : Toolbar = findViewById(R.id.toolbar)
//        toolbar.setTitle("")

//        setSupportActionBar(toolbar)

//        bottomNavigationView.setupWithNavController(navController)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.dashbroadFragment,
//                R.id.searchFragment,
//                R.id.cartFragment,
//                R.id.profileFragment
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)

        replaceFragment(dashbroadFragment)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashbroadFragment -> replaceFragment(dashbroadFragment)
                R.id.searchFragment -> replaceFragment(searchFragment)
                R.id.cartFragment -> replaceFragment(cartFragment)
                R.id.profileFragment -> replaceFragment(profileFragment)
            }
            true
        }

    }

    fun replaceFragment (fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.nav_search){
//            Toast.makeText(this, "Clicked search", Toast.LENGTH_SHORT)
//        }
        if (item.itemId == R.id.nav_noti){
            Toast.makeText(this, "Clicked notifications", Toast.LENGTH_SHORT)
        }
        return super.onOptionsItemSelected(item)
    }
}